package com.bitchart.server.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bitchart.server.bean.TickerBean;
import com.bitchart.server.pool.TickerPoolService;
import com.bitchart.server.repository.TickerRepository;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = TickerService.class, secure = false)
public class TickerServiceMockTest {

    private static final String BITCOIN = "bitcoin";
    private static final String LITCOIN = "litcoin";
    private static final String ETHER = "ether";
    private static final String RIPPLE = "ripple";
    private static final String QTOM = "qtom";

    @Autowired
    private TickerService service;

    @MockBean
    private TickerPoolService poolService;

    @MockBean
    private TickerRepository repository;

    @MockBean
    private  TickerMapper mapper;

    private TickerBean mockTickerBean = getMockTickerBean(BITCOIN);
    private List<TickerBean> mockTickerBeanList = getMockTickerBeanList();

    @Test
    public void shouldNotBeNull() throws InterruptedException {
        Assert.assertNotNull(service);
    }

    @Test
    public void getTickerDummyTest() {
        Mockito.when(poolService.getTicker(BITCOIN)).thenReturn(null);
        TickerBean ticker = service.getTicker(BITCOIN);
        Assert.assertNotNull(ticker);
    }
    
    @Test
    public void getTickerExceptionTest() {
        Mockito.when(poolService.getTicker(BITCOIN)).thenThrow(new RuntimeException("Dummy RuntimeException"));
        TickerBean ticker = service.getTicker(BITCOIN);
        Assert.assertNotNull(ticker);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void getTickerNullParamTest() {
        TickerBean ticker = service.getTicker(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void getTickerEmptyParamTest() {
        TickerBean ticker = service.getTicker("");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void getTickerBlankParamTest() {
        TickerBean ticker = service.getTicker("   ");
    }

    @Test
    public void getTickerMockTest() {
        Mockito.when(poolService.getTicker(BITCOIN)).thenReturn(mockTickerBean);
        TickerBean ticker = service.getTicker(BITCOIN);
        Assert.assertNotNull(ticker);
    }

    @Test
    public void getAllTickerTest() {
        Mockito.when(poolService.getAllTicker()).thenReturn(mockTickerBeanList);
        List<TickerBean> tickers = service.getAllTicker();
        Assert.assertNotNull(tickers);
        Assert.assertTrue(tickers.size() > 0);
    }

    private List<TickerBean> getMockTickerBeanList() {
        return Arrays.asList(getMockTickerBean(BITCOIN), getMockTickerBean(LITCOIN), getMockTickerBean(ETHER),
                getMockTickerBean(QTOM), getMockTickerBean(RIPPLE));
    }

    private TickerBean getMockTickerBean(String tickerName) {
        Random random = new Random();
        TickerBean bean = new TickerBean();
        bean.setId(String.valueOf(tickerName.hashCode()));
        bean.setLastUpdated(new Date());
        bean.setLastUpdatedTime(String.valueOf(System.currentTimeMillis()));
        bean.setName(tickerName);
        bean.setPercentChange1H(random.nextDouble());
        bean.setPercentChange24H(random.nextDouble());
        bean.setPriceUsd(random.nextDouble());
        bean.setSequenceId(tickerName.hashCode());
        bean.setSymbol(tickerName.toUpperCase());
        bean.setVolumeUsd24Usd(random.nextLong());
        return bean;
    }

}
