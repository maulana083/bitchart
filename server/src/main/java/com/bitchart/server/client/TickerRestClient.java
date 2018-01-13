package com.bitchart.server.client;

import java.util.List;

import com.bitchart.server.bean.TickerBean;


/**
 * @author Vinayak More
 *
 * @date 13-Jan-2018
 */
public interface TickerRestClient {

    public abstract List<TickerBean> getAllTickers();

}
