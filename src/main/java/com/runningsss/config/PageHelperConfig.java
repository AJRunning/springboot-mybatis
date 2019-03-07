package com.runningsss.config;

import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xalan.internal.utils.XMLSecurityPropertyManager;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author liqings
 * @date 2019-03-07
 */
@Configuration
public class PageHelperConfig {

    @Bean
    PageHelper pageHelper(){
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        return pageHelper;
    }
}
