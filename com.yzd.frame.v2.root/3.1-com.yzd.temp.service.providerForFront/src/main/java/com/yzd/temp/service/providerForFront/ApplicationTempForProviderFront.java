package com.yzd.temp.service.providerForFront;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CountDownLatch;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan({"com.yzd.db.temp.dao"})
@ImportResource("classpath:com-yzd-temp-service-providerForFront.xml")
public class ApplicationTempForProviderFront {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationTempForProviderFront.class);
    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

    /***
     * 用于前台dubbo调用
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //init();
        logger.info("项目启动--BEGIN");
        ApplicationContext ctx = SpringApplication.run(ApplicationTempForProviderFront.class, args);
        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        logger.info("项目启动--END");
        closeLatch.await();
    }
    private static void init(){
        //解决dubbo找不到log4j
        /* log4j:WARN No appenders could be found for logger (com.alibaba.dubbo.common.logger.LoggerFactory).
        log4j:WARN Please initialize the log4j system properly.
        log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info*/
        System.setProperty("dubbo.application.logger","slf4j");
        //
    }
}