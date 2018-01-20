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

    private static final DateFormat df = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    @JsonIgnore
    private Date lastUpdated;

    private String id;
    private int sequenceId;
    private String name;
    private String symbol;
    private double priceUsd;
    private double percentChange24H;
    private double percentChange1H;
    private String lastUpdatedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
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
    
    

    public double getPercentChange24H() {
        return percentChange24H;
    }

    public void setPercentChange24H(double percentChange24H) {
        this.percentChange24H = percentChange24H;
    }

    public double getPercentChange1H() {
        return percentChange1H;
    }

    public void setPercentChange1H(double percentChange1H) {
        this.percentChange1H = percentChange1H;
    }

    @Override
    public String toString() {
        return "TickerBean [id=" + id + ", name=" + name + ", symbol=" + symbol + ", priceUsd=" + priceUsd
                + ", lastUpdated=" + lastUpdated + "]";
    }
}
