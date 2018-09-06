import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.mapper.MapperScannerConfigurer
import org.springframework.jdbc.datasource.DataSourceTransactionManager

import com.alibaba.druid.pool.DruidDataSource
import com.atd681.mybatis.interceptor.SQLInterceptor

beans {

    xmlns context: "http://www.springframework.org/schema/context"
    xmlns tx: "http://www.springframework.org/schema/tx"

    // 启动注解方式
    context.'annotation-config'()

    // DRUID数据源
    dataSource(DruidDataSource){
        driverClassName = "com.mysql.jdbc.Driver"
        url = "jdbc:mysql://localhost:3306/atd681-db"
        username = "root"
        password = ""
        filters = "stat"
        maxActive = 20
        initialSize = 5
    }

    // Mybatis拦截器
    sqlInterceptor(SQLInterceptor)

    // Mybatis配置
    sqlSessionFactory(SqlSessionFactoryBean) {
        dataSource = ref("dataSource")
        mapperLocations = "classpath*:/com/atd681/mybatis/interceptor/*_mapper.xml"
        
        // 配置Mybatis拦截器
        plugins = [
            sqlInterceptor
        ] 
    }

    // Mybatis扫描配置
    mapperScannerConfigurer(MapperScannerConfigurer){
        basePackage = "com.atd681.mybatis.interceptor"
        annotationClass = "org.springframework.stereotype.Repository"
    }

    // 事务管理器配置
    transactionManager(DataSourceTransactionManager) { 
        dataSource = ref("dataSource") 
    }

}
