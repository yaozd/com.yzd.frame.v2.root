package com.yzd.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan({"com.yzd.web.api","com.yzd.web.service"})
@ImportResource("classpath:com-yzd-web-api.xml")
public class ApplicationWebApi {
    /**
     * Used when run as JAR
     */
    public static void main(String[] args) {
        init();
        SpringApplication.run(ApplicationWebApi.class, args);

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
