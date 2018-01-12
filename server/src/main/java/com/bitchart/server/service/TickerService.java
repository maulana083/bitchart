package com.bitchart.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitchart.server.bean.Ticker;
import com.bitchart.server.pool.TickerPoolService;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Service
public class TickerService {

    @Autowired
    private TickerPoolService poolService;

    public Ticker getTicker(String tickerId) {
        return poolService.getTicker(tickerId);
    }

}
