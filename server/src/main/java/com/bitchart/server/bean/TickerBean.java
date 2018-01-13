package com.bitchart.server.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vinayak More
 *
 * @date 13-Jan-2018
 */
/**
 *
 */
public class TickerBean {

    private static DateFormat df = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");

    private String id;
    private String name;
    private String symbol;
    private double priceUsd;
    @JsonIgnore
    private Date lastUpdated;
    private String lastUpdatedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedTime() {
        return df.format(this.lastUpdated);
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    @Override
    public String toString() {
        return "TickerBean [id=" + id + ", name=" + name + ", symbol=" + symbol + ", priceUsd=" + priceUsd
                + ", lastUpdated=" + lastUpdated + "]";
    }
}
