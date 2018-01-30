package com.bitchart.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bitchart.server.bean.TimeFrame;

/**
 * @author Vinayak More
 *
 * @date 27-Jan-2018
 */
@Service
public class TechnicalAnalysisService {

    // method for relative strenght index
    public List<TimeFrame> getRSI(List<TimeFrame> data, Function<TimeFrame, Double> field, int period) {
        List<TimeFrame> result = new ArrayList<TimeFrame>();
        if (CollectionUtils.isEmpty(data)) {
            return result;
        }
        double gain = 0, loss = 0, change = 0, rsi = 0;
        List<Double> tickers = data.stream().map(field).collect(Collectors.toList());
        for (int i = period + 1; i < data.size(); i++) {
            TimeFrame currFrame = new TimeFrame();
            currFrame.setTimestamp(data.get(i).getTimestamp());
            gain = loss = change = 0;
            for (int j = i - period; j <= i; j++) {
                change = tickers.get(j) - tickers.get(j - 1);
                gain += Math.max(0, change);
                loss += Math.max(0, -change);
            }
            change = gain + loss;
            // to avoid divide by 0 exception
            rsi = change == 0 ? 50 : 100 * gain / change;
            currFrame.setMid(rsi);
            result.add(currFrame);
        }
        return result;
    }

    // method for simple moving average
    public List<TimeFrame> getSMA(List<TimeFrame> data, Function<TimeFrame, Double> field, int period) {
        List<TimeFrame> result = new ArrayList<TimeFrame>();
        if (CollectionUtils.isEmpty(data)) {
            return result;
        }
        double gain = 0, loss = 0, change = 0, sma = 0;
        List<Double> tickers = data.stream().map(field).collect(Collectors.toList());
        for (int i = period; i < data.size(); i++) {
            TimeFrame currFrame = new TimeFrame();
            currFrame.setTimestamp(data.get(i).getTimestamp());
            gain = loss = change = 0;
            for (int j = i - period; j <= i; j++) {
                change += tickers.get(j);

            }
            sma = change / period;
            currFrame.setMid(sma);
            result.add(currFrame);
        }
        return result;
    }
}
