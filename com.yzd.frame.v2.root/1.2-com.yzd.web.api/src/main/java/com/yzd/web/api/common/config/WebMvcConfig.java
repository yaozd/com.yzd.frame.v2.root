package com.yzd.web.api.common.config;

import com.yzd.web.api.common.interceptorExt.ApiLoginInterceptor;
import com.yzd.web.api.common.interceptorExt.ApiTokenInterceptor;
import com.yzd.web.api.common.interceptorExt.CORSHandlerInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * SpringMvc_@RequestMapping设置Router Url大小写不敏感
     * http://www.cnblogs.com/gossip/p/5441358.html
     * 如何取消 /index.*映射
     * http://www.oschina.net/question/190714_116949
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
        configurer.setUseSuffixPatternMatch(false);
    }

    @Value("${swagger.enable}")
    private boolean swaggerShow;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //在生产环境中禁打开/swagger-ui.html
        if(!swaggerShow){
            registry.addResourceHandler("/swagger-ui.html").addResourceLocations(
                    "classpath:/noswagger");
        }
    }

    @Value("${appPath}")
    private String appPath;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //解决前后端分离的 CORS 跨域资源共享问题
        registry.addInterceptor(new CORSHandlerInterceptor()).addPathPatterns("/**");
        //Token验证
        registry.addInterceptor(new ApiTokenInterceptor())
                .addPathPatterns(getFullPath("/api/**"))
                //除“/api/token/getBaseToken”以外所有的请求都必须包含Token信息
                .excludePathPatterns(getFullPath("/api/token/getBaseToken"));
        //
        //登录验证
        registry.addInterceptor(new ApiLoginInterceptor())
                .addPathPatterns(getFullPath("/api/user/**"))
                .addPathPatterns(getFullPath("/api/account/doLogout"));
        //
    }
    private String getFullPath(String path){
        String fullPath=String.format("/%s%s",appPath,path);
        return StringUtils.replace(fullPath,"//","/");
    }

}

