import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration

beans {

    xmlns context: "http://www.springframework.org/schema/context"

    // 启动注解方式
    context.'annotation-config'()

    // 配置Spring Session
    // 实际上是配置Web.xml中使用的Spring Session过滤器
    // 将Tomcat的Session替换为Redis中管理的Session
    sessionConfig(RedisHttpSessionConfiguration)

    // 配置Redis客户端连接
    // 默认连接本地6379端口
    lettuce(LettuceConnectionFactory)

}
