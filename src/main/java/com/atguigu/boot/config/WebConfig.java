package com.atguigu.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper=new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);//取消默认移除请求路径中的分号以及其后面的所有内容 ,以便使用 矩阵变量功能
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }



//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer){
//        UrlPathHelper urlPathHelper=new UrlPathHelper();
//        urlPathHelper.setRemoveSemicolonContent(false);//取消默认移除请求路径中的分号 , 以便使用 矩阵变量功能
//        configurer.setUrlPathHelper(urlPathHelper);
//    }


}
