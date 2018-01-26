package com.bitchart.server.pool;

import com.bitchart.server.client.TickerRestClient;

/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
public class TickerPoolCommand implements Runnable {

    private TickerRestClient client;
    private TickerPoolBean bean;

    public TickerPoolCommand(TickerRestClient client, TickerPoolBean bean) {
        super();
        this.client = client;
        this.bean = bean;
    }

    @Override
    public void run() {
        try {
            bean.populateMap(client.getAllTickers());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
