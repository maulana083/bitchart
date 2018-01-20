package com.bitchart.server.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitchart.server.bean.TickerBean;
import com.bitchart.server.bean.TickerEntity;
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

}
