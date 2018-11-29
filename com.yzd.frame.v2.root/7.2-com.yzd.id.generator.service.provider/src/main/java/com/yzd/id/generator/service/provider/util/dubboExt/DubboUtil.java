package com.yzd.id.generator.service.provider.util.dubboExt;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.TimeZone;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;


public class DubboUtil {
    private static final Logger logger = LoggerFactory.getLogger(DubboUtil.class);
    /***
     * dubbo运行初始化-启动时属性设置
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
        if(isBlank(packageTimestamp)){
            packageTimestamp="没有找到【当前非Maven打包后运行】";
        }else {
            System.setProperty("dubbo.package.timestamp", packageTimestamp);
        }
        logger.info("项目打包时间截--timestamp:"+packageTimestamp);
        return packageTimestamp;
    }
    private static String getTimestamp(){
        URL url=getManifestURL();
        if(url==null){
            return null;
        }
        //logger.info(url.getPath());
        InputStream is =null;
        try {
            is =url.openStream();
            Manifest manifest = new Manifest(is);
            Attributes attr = manifest.getMainAttributes();
            String value = attr.getValue("Timestamp");
            if(isBlank(value)){
                return null;
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("yyMMddHHmmss").format(df.parse(value));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    /***
     * 获得本包的ManifestURL
     */
    private static URL  getManifestURL(){
        //打包后本地包的默认路径
        URL defaultURL = DubboUtil.class .getProtectionDomain().getCodeSource().getLocation();
        String localPath=defaultURL.getFile();
        int endIndex = localPath.indexOf("jar!")-1;
        if(endIndex<0){
            return null;
        }
        localPath=localPath.substring(0,endIndex);
        Enumeration resEnum;
        try {
            resEnum = new MyResources().getClass().getClassLoader().getResources(JarFile.MANIFEST_NAME);
            while (resEnum.hasMoreElements()) {
                try {
                    URL url = (URL)resEnum.nextElement();
                    System.out.println(url.getFile());
                    //凑数是否是当前程序的jar包
                    if(!url.getFile().contains(localPath)){
                        continue;
                    }
                    return url;
                }
                catch (Exception e) {
                    // Silently ignore wrong manifests on classpath?
                }
            }
        } catch (IOException e1) {
            // Silently ignore wrong manifests on classpath?
        }
        return null;
    }
    private static boolean isBlank(String value){
        return value==null||value.trim().length()==0;
    }
    static class MyResources{}
}