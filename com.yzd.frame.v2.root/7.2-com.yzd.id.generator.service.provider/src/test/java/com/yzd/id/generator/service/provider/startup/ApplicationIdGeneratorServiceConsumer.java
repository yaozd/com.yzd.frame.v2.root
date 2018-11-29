package com.yzd.id.generator.service.provider.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

/**
 * Created by zd.yao on 2017/3/30.
 */
@ImportResource("classpath:com-yzd-id-generator-service-consumer.xml")
public class ApplicationIdGeneratorServiceConsumer {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationIdGeneratorServiceConsumer.class);
    public static void main(String[] args) throws IOException {
        logger.info("项目启动--BEGIN");
        SpringApplication.run(ApplicationIdGeneratorServiceConsumer.class, args);
    }
}