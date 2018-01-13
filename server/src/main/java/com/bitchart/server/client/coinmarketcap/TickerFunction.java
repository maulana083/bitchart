package com.bitchart.server.client.coinmarketcap;

import java.util.Date;
import java.util.function.Function;

import com.bitchart.server.bean.Ticker;
import com.bitchart.server.bean.TickerBean;

/**
 * @author Vinayak More
 *
 * @date 13-Jan-2018
 */
public class TickerFunction implements Function<Ticker, TickerBean> {

    @Override
    public TickerBean apply(Ticker t) {
        TickerBean bean = new TickerBean();
        bean.setId(t.getId());
        bean.setName(t.getName());
        bean.setSymbol(t.getSymbol());
        bean.setPriceUsd(Double.parseDouble(t.getPriceUsd()));
        bean.setLastUpdated(new Date(Long.parseLong(t.getLastUpdated())*1000));
        return bean;
    }

}

