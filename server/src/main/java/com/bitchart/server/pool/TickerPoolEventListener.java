package com.bitchart.server.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.bitchart.server.service.TickerService;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Component
public class TickerPoolEventListener {

    @Autowired
    private TickerService service;
    

    @EventListener
    public void onTickerPoolUpdated(TickerPoolUpdatedEvent event) {
        service.saveAllTickerData();
    }
}
