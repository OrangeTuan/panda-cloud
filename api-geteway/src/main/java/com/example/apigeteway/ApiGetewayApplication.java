package com.example.apigeteway;

import com.example.apigeteway.Filter.AccessFilter;
import com.example.apigeteway.Filter.DidiFilterProcessor;
import com.example.apigeteway.Filter.ThrowExceptionFilter;
import com.example.apigeteway.error.DidiErrorAttributes;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ApiGetewayApplication {

    public static void main(String[] args) {
        FilterProcessor.setProcessor(new DidiFilterProcessor());
        SpringApplication.run(ApiGetewayApplication.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

//    @Bean
//    public ThrowExceptionFilter throwExceptionFilter() {
//        return new ThrowExceptionFilter();
//    }

    @Bean
    @ConditionalOnMissingBean(value = ErrorAttributes.class, search = SearchStrategy.CURRENT)
    public DefaultErrorAttributes errorAttributes() {
        //启动自定义的异常信息
        return new DidiErrorAttributes();
    }

    /**
     * 自定义路由映射规则
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
          "(?<name>^.+)-(?<version>v.+$)",
                "$(version)/$(name)"
        );
    }

}
