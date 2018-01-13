package com.bitchart.server.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bitchart.server.bean.Ticker;
import com.bitchart.server.bean.TickerEntity;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Component
public class TickerMapper {

    public TickerEntity map(Ticker ticker) {
        TickerEntity entity = new TickerEntity();
        entity.setTickerId(ticker.getId());
        entity.setTickerName(ticker.getName());
        entity.setSymbol(ticker.getSymbol());
        entity.setPriceUsd(Double.parseDouble(ticker.getPriceUsd()));
        entity.setLastUpdated(new Timestamp(Long.parseLong(ticker.getLastUpdated())*1000));
        entity.setLastUpdatedStr(ticker.getLastUpdated());
        return entity;
    }

    public List<TickerEntity> mapList(List<Ticker> tickers) {
        return tickers.stream().map(e -> map(e)).collect(Collectors.toList());
    }
}
