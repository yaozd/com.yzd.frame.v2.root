package com.yzd.id.generator.service.provider.util.dubboExt;

import com.alibaba.dubbo.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.TimeZone;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

@Slf4j
public class DubboUtil {

    /***
     * dubbo-启动时属性设置
     */
    public static void initForRun(){
        setLogInit();
        setPackageTimestamp();
    }
    //设置dubbo的日志属性
    private static void setLogInit() {
        //解决dubbo找不到log4j
        /* log4j:WARN No appenders could be found for logger (com.alibaba.dubbo.common.logger.LoggerFactory).
        log4j:WARN Please initialize the log4j system properly.
        log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info*/
        System.setProperty("dubbo.application.logger","slf4j");
        //
    }
    //设置dubbo打包的版本号
    private static String setPackageTimestamp() {
        String packageTimestamp=getTimestamp();
        if(StringUtils.isBlank(packageTimestamp)){
            packageTimestamp="没有找到【当前非Maven打包后运行】";
        }else {
            System.setProperty("dubbo.package.timestamp", packageTimestamp);
        }
        log.info("项目打包时间截--timestamp:"+packageTimestamp);
        return packageTimestamp;
    }
    //private static final String MANIFEST_DIRECTORY_LOCATION = "META-INF" + File.separator + "MANIFEST.MF";
    private static final String MANIFEST_DIRECTORY_LOCATION = "META-INF/MANIFEST.MF";
    private static String getTimestamp(){
     return null;
    }

}