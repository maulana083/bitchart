package com.bitchart.server.boot;


import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.bitchart.server.ServerApplication;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Configuration
@ComponentScan(basePackageClasses = ServerApplication.class)
public class ApplicationConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
       
}
