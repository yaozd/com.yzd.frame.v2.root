import com.alibaba.dubbo.common.utils.StringUtils;
import com.yzd.id.generator.service.provider.util.dubboExt.DubboUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

@SpringBootApplication
@ComponentScan({"com.yzd.id.generator.service.provider"})
@ImportResource("classpath:com-yzd-id-generator-service-provider.xml")
public class ApplicationIdGeneratorServiceProvider {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationIdGeneratorServiceProvider.class);
    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

    public static void main(String[] args) throws InterruptedException {
        DubboUtil.initForRun();
        logger.info("项目启动--BEGIN");
        ApplicationContext ctx = SpringApplication.run(ApplicationIdGeneratorServiceProvider.class, args);
        logger.info("项目启动--END");
        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        closeLatch.await();
    }
}