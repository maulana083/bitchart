package com.bitchart.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitchart.server.bean.Ticker;
import com.bitchart.server.bean.TimeFrame;
import com.bitchart.server.service.TickerService;

/**
 * @author Vinayak More
 *
 * @date 25-Jan-2018
 */
@RestController
public class GraphController {
    
    @Autowired
    private TickerService service;
    
    @RequestMapping("/graph/{tickerId}")
    public List<TimeFrame> getGraphData(@PathVariable String tickerId,@RequestParam String unit,@RequestParam int scale){
        return service.getTimeFrames(tickerId,unit,scale);
    }

}

