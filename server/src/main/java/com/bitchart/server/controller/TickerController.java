package com.bitchart.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitchart.server.bean.TickerBean;
import com.bitchart.server.service.TickerService;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Controller
public class TickerController {

    @Autowired
    private TickerService service;
    
    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(value = "/tickers", method = RequestMethod.GET)
    public List<TickerBean> getAllTicker() {
        return service.getAllTicker();
    }

    @RequestMapping(value = "/tickers/{tickerId}", method = RequestMethod.GET)
    public TickerBean getTicker(@PathVariable("tickerId") String tickerId) {
        return service.getTicker(tickerId);
    }
    
    @MessageMapping("/hello")
    @SendTo("/ws/greetings")
    @Scheduled(fixedDelay=30000)
    public void greeting() throws Exception {
        System.out.println("TickerController.greeting()");
        template.convertAndSend("/ws/greetings", service.getAllTicker());
    }

}
