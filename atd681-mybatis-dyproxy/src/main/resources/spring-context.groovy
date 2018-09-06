import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.mapper.MapperScannerConfigurer

import com.alibaba.druid.pool.DruidDataSource


beans {

    xmlns context: "http://www.springframework.org/schema/context"

    // 启动注解方式
    context.'annotation-config'()
    
    // database connection config
    dataSource(DruidDataSource){
        driverClassName = "com.mysql.jdbc.Driver"
        url = "jdbc:mysql://localhost:3306/atd681-db"
        username = "root"
        password = ""
        filters = "stat"
        maxActive = 20
        initialSize = 5
    }

    // mybatis config
    sqlSessionFactory(SqlSessionFactoryBean) {
        dataSource = ref("dataSource")
        typeAliasesPackage = "com.atd681.mybatis.dyproxy.model"
        mapperLocations = "classpath*:/com/atd681/mybatis/dyproxy/dao/*_mapper.xml"
    }

    // mybatis mapper scan, need interface only
    mapperScannerConfigurer(MapperScannerConfigurer){
        basePackage = "com.atd681.mybatis.dyproxy.dao"
        annotationClass = "org.springframework.stereotype.Repository"
    }

}
