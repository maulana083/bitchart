package com.bitchart.server.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bitchart.server.bean.TickerBean;
import com.bitchart.server.client.TickerRestClient;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Service
public class TickerPoolService {

    @Value("${thread.pool.size}")
    private int threadPoolSize;

    @Value("${thread.pool.period}")
    private int period;

    @Autowired
    private TickerRestClient client;

    @Autowired
    private TickerPoolBean bean;

    private ScheduledExecutorService service = Executors.newScheduledThreadPool(threadPoolSize);

    @PostConstruct
    public void initPool() {
        System.out.println("TickerPoolService.initPool()");
        service.scheduleAtFixedRate(new TickerPoolCommand(client, bean), 0, period, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("TickerPoolService.shutdown()");
        service.shutdown();
    }
    
    public TickerBean getTicker(String tickerId){
        return bean.getTicker(tickerId);
    }

    public List<TickerBean> getAllTicker() {
        return new ArrayList<TickerBean>(bean.getAllTicker());
    }


}
