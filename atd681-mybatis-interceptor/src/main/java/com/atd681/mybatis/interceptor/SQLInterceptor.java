package com.atd681.mybatis.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.alibaba.druid.pool.DruidPooledPreparedStatement;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl;

/**
 * Mybatis拦截器:拦截所有的增删改SQL,将SQL保持至数据库
 */
// @Intercepts注解为Mybatis提供的拦截器器注解, @Signature注解中指定拦截的操作(方法)
// type为拦截的组件(类), Mybatis不同操作调用不同的组件
// method为拦截的方法, 当方法被Mybatis执行时先进入拦截器
// args为方法的参数, 由于JAVA有重载, 因此通过方法名和参数类型才能确定唯一的方法
@Intercepts(@Signature(type = StatementHandler.class, method = "update", args = Statement.class))
public class SQLInterceptor implements Interceptor {

    // 拦截StatementHandler.update方法后执行
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        // invocation.getArgs()可以获取到被拦截方法的参数
        // StatementHandler.update(Statement s)的参数为Statement
        Statement s = (Statement) invocation.getArgs()[0];

        // 数据源为DRUID, Statement为DRUID的Statement
        Statement stmt = ((DruidPooledPreparedStatement) s).getStatement();

        // 配置druid连接时使用filters: stat配置
        if (stmt instanceof PreparedStatementProxyImpl) {
            stmt = ((PreparedStatementProxyImpl) stmt).getRawObject();
        }

        // 数据库提供的Statement可获取参数替换后的SQL(JDBC和DRUID获取的是带?的)
        // 数据库为MySQL,可以直接强制转换为MySQL的PreparedStatement获取SQL
        // SQL在书写时为了格式容器阅读会有换行符(多个空格)存在
        // 为了保存和查看方便去除SQL中的换行及多个空格
        String sql = ((com.mysql.jdbc.PreparedStatement) stmt).asSql().replaceAll("\\s+", " ");

        // 保存SQL的操作必须和当前执行的SQL在同一事务中
        // 使用当前SQL所在的数据库连接执行保存操作即可
        // 目标sql成功时保存sql的方法也同步成功
        Connection conn = stmt.getConnection();

        // 将SQL保存至数据库中
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO atd681_mybatis_sql (v_sql) VALUES (?)");
            ps.setString(1, sql);

            // 因为和Mybatis的操作在同一事务中
            // 如果本次操作如果失败, 所有操作都回滚
            ps.execute();
        }
        finally {
            if (ps != null) {
                ps.close();
            }
        }

        // 继续执行Mybatis原有的逻辑
        // proceed中通过反射执行被拦截的方法
        return invocation.proceed();

    }

    // 返回当前拦截的对象(StatementHandler)的动态代理
    // 当拦截对象的方法被执行时, 动态代理中执行拦截器intercept方法.
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    // 无需处理
    @Override
    public void setProperties(Properties properties) {
    }

}
