package com.yzd.web.api.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
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

}
