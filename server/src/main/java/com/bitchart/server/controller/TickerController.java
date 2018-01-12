package com.bitchart.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitchart.server.bean.Ticker;
import com.bitchart.server.service.TickerService;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@RestController
public class TickerController {

    @Autowired
    private TickerService service;

    @RequestMapping(value = "/tickers", method = RequestMethod.GET)
    public List<Ticker> getAllTicker() {
        return service.getAllTicker();
    }

    @RequestMapping(value = "/tickers/{tickerId}", method = RequestMethod.GET)
    public Ticker getTicker(@PathVariable("tickerId") String tickerId) {
        return service.getTicker(tickerId);
    }

}
