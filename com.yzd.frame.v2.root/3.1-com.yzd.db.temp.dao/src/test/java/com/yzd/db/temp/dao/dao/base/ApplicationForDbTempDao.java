package com.yzd.db.temp.dao.dao.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan("com.yzd.db.temp.dao")
public class ApplicationForDbTempDao {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationForDbTempDao.class, args);
    }
}