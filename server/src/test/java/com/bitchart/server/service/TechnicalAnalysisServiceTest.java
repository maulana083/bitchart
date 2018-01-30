package com.bitchart.server.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bitchart.server.TimeFrameTest;
import com.bitchart.server.bean.TimeFrame;

/**
 * @author Vinayak More
 *
 * @date 27-Jan-2018
 */
public class TechnicalAnalysisServiceTest {

    private TechnicalAnalysisService service = new TechnicalAnalysisService();

    @Test
    public void getRSITest() {

    }

    private List<TimeFrameTest> getTestData() {
        List<TimeFrameTest> data = new ArrayList<TimeFrameTest>();
        InputStream in = TimeFrame.class.getResourceAsStream("testdata.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while((line=br.readLine())!=null){
                 
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
