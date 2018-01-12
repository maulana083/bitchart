package com.bitchart.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitchart.server.bean.TickerEntity;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
public interface TickerRepository extends CrudRepository<TickerEntity, Long> {
    
}
