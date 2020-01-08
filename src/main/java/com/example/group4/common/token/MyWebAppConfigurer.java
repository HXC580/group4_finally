package com.example.group4.common.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @BelongsProject:
 * @BelongsPackage: com.jdtaste.jdtastesso.conf
 * @Author:
 * @CreateTime: 2018-07-04 10:03
 * @Description: 配置URLInterceptor拦截器，以及拦截路径
 */
/**
 * @BelongsProject:
 * @BelongsPackage: com.jdtaste.jdtastesso.conf
 * @Author:
 * @CreateTime: 2018-07-04 10:03
 * @Description: 配置URLInterceptor拦截器，以及拦截路径
 */
@EnableWebMvc
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/*/*");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
        WebMvcConfigurer.super.addArgumentResolvers(argumentResolvers);
    }

    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }

    /**
     * 解决 拦截器中注入bean 失败情况出现
     * addArgumentResolvers方法中 添加
     *  argumentResolvers.add(currentUserMethodArgumentResolver());
     */
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }




@Bean
public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver2() {
        return new CurrentUserMethodArgumentResolver();
        }

/**
 * 解决 拦截器中注入bean 失败情况出现
 * addArgumentResolvers方法中 添加
 *  argumentResolvers.add(currentUserMethodArgumentResolver());
 */
@Bean
public AuthenticationInterceptor authenticationInterceptor2() {
        return new AuthenticationInterceptor();
        }
        }
