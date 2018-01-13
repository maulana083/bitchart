package com.bitchart.server.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.bitchart.server.bean.TickerBean;
import com.bitchart.server.boot.ApplicationConfiguration;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationConfiguration.class)
@TestPropertySource(locations = "classpath:application.properties")
public class TickerServiceTest {
    
    @Autowired
    private TickerService service;
    
    
    @Test
    public void shouldNotBeNull() throws InterruptedException{
        Assert.assertNotNull(service);
        Thread.sleep(5000);
    }
    
    @Test 
    public void getTickerTest(){
        TickerBean ticker = service.getTicker("bitcoin");
        Assert.assertNotNull(ticker);
        System.out.println("BITCHART:tickerId:"+ticker.getId());
        System.out.println("BITCHART:tickerPrice:"+ticker.getPriceUsd());
        
    }

}

