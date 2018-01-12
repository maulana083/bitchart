package com.bitchart.server.pool;
/**
 * @author Vinayak More
 *
 * @date 12-Jan-2018
 */
public class TickerPoolUpdatedEvent {

    private final long updatedTimeMillis;

    public TickerPoolUpdatedEvent(long updatedTimeMillis) {
        this.updatedTimeMillis = updatedTimeMillis;
    }

    public long getUpdatedTimeMillis() {
        return updatedTimeMillis;
    }
}

