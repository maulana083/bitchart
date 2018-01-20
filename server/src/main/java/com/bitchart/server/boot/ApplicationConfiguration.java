package com.bitchart.server.boot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.bitchart.server.ServerApplication;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Configuration
@ComponentScan(basePackageClasses = ServerApplication.class)
@EnableScheduling
public class ApplicationConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
       
}
