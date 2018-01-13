package com.bitchart.server.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bitchart.server.bean.TickerBean;
import com.bitchart.server.bean.TickerEntity;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
@Component
public class TickerMapper {

    public TickerEntity map(TickerBean ticker) {
        TickerEntity entity = new TickerEntity();
        entity.setTickerId(ticker.getId());
        entity.setTickerName(ticker.getName());
        entity.setSymbol(ticker.getSymbol());
        entity.setPriceUsd(ticker.getPriceUsd());
        entity.setLastUpdated(new Timestamp(ticker.getLastUpdated().getTime()));
        return entity;
    }

    public List<TickerEntity> mapList(List<TickerBean> tickers) {
        return tickers.stream().map(e -> map(e)).collect(Collectors.toList());
    }
}
