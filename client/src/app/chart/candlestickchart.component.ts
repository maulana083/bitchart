import { Component, OnInit, Input} from '@angular/core';
import { Ticker } from '../ticker';
import { GraphService } from '../graph.service';
import { TimeFrame } from '../timeframe';
declare var google:any;

@Component({
    selector:"candlestick-chart",
    template:'<div id="candlestick-chart"></div>',
    styles:['#chart{ width:100%; height:100%;}']
})
export class CandleStickChartComponent implements OnInit{

    @Input() ticker:Ticker;
    timeFrames:TimeFrame[];
    constructor(private graphService:GraphService){

    }

    ngOnInit():void{
        this.getChartData();
        
    }

    getChartData():void{
        this.graphService.getGraphData(this.ticker.id,"hour","1")
        .subscribe(timeFrame=>{
            this.drawChart(timeFrame);
            this.timeFrames=timeFrame;
        });
        
    }

    drawChart(data:TimeFrame[]):void{
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);
        const graphData=data.map(t=>{
            return [new Date(t.timestamp),t.low,t.open,t.close,t.high]
        });
        
        console.log(graphData);
        function drawChart() {

            var data = google.visualization.arrayToDataTable(graphData.slice(2,graphData.length), true);
            
            var options = {
                legend:'none'
              };

              var chart = new google.visualization.CandlestickChart
              (document.getElementById('candlestick-chart'));

            chart.draw(data, options);
        }

        
    }
}