package com.bitchart.server.repository;

import java.sql.Timestamp;
import java.util.Collection;

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
    
    public TickerEntity findByTickerIdAndLastUpdated(String tickerId,Timestamp lastUpdated);
    
    public Collection<TickerEntity> findByTickerId(String tickerId);
    
}
