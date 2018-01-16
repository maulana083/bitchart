package com.bitchart.server.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bitchart.server.bean.Ticker;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Component
public class TickerRestClient {
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${ticker.base.url}")
    private String tickerBaseUrl;
    
    
    public List<Ticker> getAllTickers(){
        return Arrays.asList(restTemplate.getForObject(tickerBaseUrl+"/ticker", Ticker[].class));
    }
    
    
}

