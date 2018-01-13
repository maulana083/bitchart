package com.bitchart.server.client;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bitchart.server.bean.Ticker;
import com.bitchart.server.bean.TickerBean;
import com.bitchart.server.client.coinmarketcap.TickerFunction;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Component
public class TickerRestClientImpl implements TickerRestClient {
    private final class FunctionImplementation implements Function<Ticker, TickerBean> {
        @Override
        public TickerBean apply(Ticker t) {
            return null;
        }
    }


    @Autowired
    private RestTemplate restTemplate;

    @Value("${ticker.base.url}")
    private String tickerBaseUrl;


    @Override
    public List<TickerBean> getAllTickers() {
        Ticker[] tickers = restTemplate.getForObject(tickerBaseUrl + "/ticker", Ticker[].class);
        List<Ticker> tickerList = Arrays.asList(tickers);
        return tickerList.stream().map(new TickerFunction()).collect(Collectors.toList());
    }


}
