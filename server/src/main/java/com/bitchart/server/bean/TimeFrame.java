package com.bitchart.server.bean;

import java.util.Date;

/**
 * @author Vinayak More
 *
 * @date 25-Jan-2018
 */
public class TimeFrame {

    private Date timestamp;
    private double open, high, low, close, mid;

    public TimeFrame() {}

    public TimeFrame(Date timestamp, double open, double high, double low, double close, double mid) {
        this.timestamp = timestamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.mid = mid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(close);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(high);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(low);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mid);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(open);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TimeFrame other = (TimeFrame) obj;
        if (Double.doubleToLongBits(close) != Double.doubleToLongBits(other.close))
            return false;
        if (Double.doubleToLongBits(high) != Double.doubleToLongBits(other.high))
            return false;
        if (Double.doubleToLongBits(low) != Double.doubleToLongBits(other.low))
            return false;
        if (Double.doubleToLongBits(mid) != Double.doubleToLongBits(other.mid))
            return false;
        if (Double.doubleToLongBits(open) != Double.doubleToLongBits(other.open))
            return false;
        if (timestamp == null) {
            if (other.timestamp != null)
                return false;
        } else if (!timestamp.equals(other.timestamp))
            return false;
        return true;
    }


}
