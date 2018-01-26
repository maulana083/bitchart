package com.bitchart.server.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bitchart.server.bean.TickerBean;
import com.bitchart.server.bean.TickerEntity;
import com.bitchart.server.bean.TimeFrame;
import com.bitchart.server.pool.TickerPoolService;
import com.bitchart.server.repository.TickerRepository;
import com.bitchart.server.utils.Constants;

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

    public TickerBean getTicker(String tickerId) {
        return poolService.getTicker(tickerId);
    }

    public List<TickerBean> getAllTicker() {
        return poolService.getAllTicker().stream()
                .sorted((o1, o2) -> Integer.compare(o1.getSequenceId(), o2.getSequenceId()))
                .collect(Collectors.toList());
    }

    public synchronized void saveAllTickerData() {
        List<TickerBean> allTicker = getAllTicker();
        if (repository.count() == 0) {
            repository.save(mapper.mapList(allTicker));
        } else {
            for (TickerBean ticker : allTicker) {
                TickerEntity entity =
                        repository.findByTickerIdAndLastUpdated(ticker.getId(), new Timestamp(ticker.getLastUpdated()
                                .getTime()));
                if (entity == null) {
                    repository.save(mapper.map(ticker));
                }
            }
        }
    }

    public List<TimeFrame> getTimeFrames(String tickerId, String unit, int scale) {
        List<TickerEntity> tickersSortedByTimestamp =
                repository.findByTickerId(tickerId).stream()
                        .sorted((o1, o2) -> o1.getLastUpdated().compareTo(o2.getLastUpdated()))
                        .collect(Collectors.toList());
        List<TimeFrame> graphData = new ArrayList<TimeFrame>();
        if (CollectionUtils.isEmpty(tickersSortedByTimestamp)) {
            return graphData;
        }

        TickerEntity p = tickersSortedByTimestamp.get(0);

        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date(p.getLastUpdated().getTime() - 1));
        int field = getCalendarField(unit);
        cd.add(field, scale);

        TimeFrame tempFrame = new TimeFrame();

        for (int i = 0, j = 0; j < tickersSortedByTimestamp.size(); j++) {
            TickerEntity currEntity = tickersSortedByTimestamp.get(j);
            double currPrice = currEntity.getPriceUsd();
            if (currEntity.getLastUpdated().getTime() - cd.getTime().getTime() <= 0) {
                if (i == j) {
                    tempFrame.setOpen(currPrice);
                }
                if (currPrice > tempFrame.getHigh()) {
                    tempFrame.setHigh(currPrice);
                }
                if (currPrice < tempFrame.getLow()) {
                    tempFrame.setLow(currPrice);
                }
                if (j == tickersSortedByTimestamp.size()) {
                    tempFrame.setTimestamp(currEntity.getLastUpdated());
                }
            } else {
                tempFrame.setClose(currPrice);
                tempFrame.setTimestamp(currEntity.getLastUpdated());
                tempFrame.setMid((tempFrame.getOpen() + tempFrame.getClose()) / 2);
                graphData.add(tempFrame);
                tempFrame = new TimeFrame();
                tempFrame.setOpen(currPrice);
                tempFrame.setHigh(currPrice);
                tempFrame.setLow(currPrice);
                tempFrame.setClose(currPrice);
                tempFrame.setMid(currPrice);
                i = j + 1;
                cd.add(field, scale);
            }
        }
        if (!graphData.contains(tempFrame)) {
            tempFrame.setTimestamp(new Date());
            graphData.add(tempFrame);
        }
        return graphData;
    }

    private int getCalendarField(String unit) {
        if (StringUtils.isBlank(unit)) {
            return Calendar.MINUTE;
        }
        String field = unit.toLowerCase();
        int value = Calendar.MINUTE;
        switch (unit) {
            case Constants.SECOND:
                value = Calendar.SECOND;
                break;
            case Constants.MINUTE:
                value = Calendar.MINUTE;
                break;
            case Constants.HOUR:
                value = Calendar.HOUR;
                break;
            case Constants.DAY:
                value = Calendar.DATE;
                break;
            default:
                value = Calendar.MINUTE;
                break;
        }
        return value;
    }
}
