package com.bitchart.server.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bitchart.server.bean.TickerEntity;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
public interface TickerRepository extends CrudRepository<TickerEntity, Long> {

    @Query("SELECT MAX(lastUpdated) FROM TickerEntity")
    public Timestamp getMaxLastUpdated();
    
    public TickerEntity findByTickerIdAndLastUpdatedStr(String tickerId,String lastUpdatedStr);
    
}
