package com.bitchart.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitchart.server.bean.Ticker;
import com.bitchart.server.pool.TickerPoolService;
import com.bitchart.server.repository.TickerRepository;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Service
public class TickerService {

    @Autowired
    private TickerPoolService poolService;

    @Autowired
    private TickerRepository repository;

    @Autowired
    private TickerMapper mapper;

    public Ticker getTicker(String tickerId) {
        return poolService.getTicker(tickerId);
    }

    public List<Ticker> getAllTicker() {
        return poolService.getAllTicker();
    }

    public void saveAllTickerData() {
        List<Ticker> allTicker = getAllTicker();
        repository.save(mapper.mapList(allTicker));
    }

}
