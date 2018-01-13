package com.bitchart.server.client;



import java.util.List;

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
@ContextConfiguration(classes = ApplicationConfiguration.class)
@TestPropertySource(locations = "classpath:application.properties")
public class TickerRestClientTest {

    @Autowired
    private TickerRestClient client;

    @Test
    public void shouldNotBeNull() {
        Assert.assertNotNull(client);
    }

    @Test
    public void getAllTickersTest() {
        List<TickerBean> tickers = client.getAllTickers();
        System.out.println("****************************************");
        System.out.println(tickers);
        System.out.println("****************************************");
        Assert.assertTrue(tickers.size() > 0);
    }



}
