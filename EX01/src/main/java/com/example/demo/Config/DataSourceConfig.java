package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;

// TODO: DataSource 빈 2개를 작성하라.
//  필요한 import : javax.sql.DataSource, org.springframework.context.annotation.Bean,
//                 org.apache.commons.dbcp2.BasicDataSource, com.zaxxer.hikari.HikariDataSource
@Configuration
public class DataSourceConfig {

    // TODO 1) @Bean dataSource2() : BasicDataSource(commons-dbcp2)
    //        - setDriverClassName("com.mysql.cj.jdbc.Driver")
    //        - setUrl("jdbc:mysql://localhost:3306/testdb"), setUsername("root"), setPassword("1234")
    // TODO 2) @Bean dataSource3() : HikariDataSource
    //        - setDriverClassName("com.mysql.cj.jdbc.Driver")
    //        - setJdbcUrl("jdbc:mysql://localhost:3306/testdb"), setUsername("root"), setPassword("1234")
    //  ※ MemberDAO 는 dataSource3(HikariDataSource) 를 주입받아 사용한다.

}
