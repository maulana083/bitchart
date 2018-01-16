package com.bitchart.server.pool;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bitchart.server.bean.Ticker;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Component
@Scope(scopeName = BeanDefinition.SCOPE_SINGLETON)
public class TickerPoolBean {

    private Map<String, Ticker> dataMap = new ConcurrentHashMap<String, Ticker>();

    @Autowired
    private ApplicationEventPublisher publisher;

    public synchronized void populateMap(List<Ticker> tickers) {
        tickers.stream().forEach(t -> dataMap.put(t.getId(), t));
        publisher.publishEvent(new TickerPoolUpdatedEvent(System.currentTimeMillis()));
    }

    public Ticker getTicker(String tickerId) {
        if (!dataMap.containsKey(tickerId)) {
            System.out.println(String.format("Error:tickerId:%s not Exists", tickerId).toString());
        }
        return dataMap.get(tickerId);
    }
    
    public Collection<Ticker> getAllTicker(){
        return dataMap.values();
    }


}
