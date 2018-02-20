import { Component, OnInit, Input} from '@angular/core';
import { Ticker } from '../ticker';
import { GraphService } from '../graph.service';
import { TimeFrame } from '../timeframe';
declare var google:any;

@Component({
    selector:"line-chart",
    template:'<div id="line_chart"></div>',
    styles:['#line_chart{ width:100%; height:100%;}']
})
export class LineChartComponent implements OnInit{

    @Input() ticker:Ticker;
    timeFrames:TimeFrame[];
    constructor(private graphService:GraphService){

    }

    ngOnInit():void{
        this.getChartData();
        
    }

    getChartData():void{
        this.graphService.getGraphData(this.ticker.id,"minute","15")
        .subscribe(timeFrame=>{
            this.drawChart(timeFrame);
            this.timeFrames=timeFrame;
        });
        
    }

    drawChart(data:TimeFrame[]):void{
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);
        const graphData=data.map(t=>{
            return [new Date(t.timestamp),t.mid]
        });
        
        function drawChart() {

            var data = new google.visualization.DataTable();
            data.addColumn('date', 'X');
            data.addColumn('number', 'Price');


            data.addRows(graphData);
            
            var options = {
                hAxis: {
                  title: 'Time'
                },
                vAxis: {
                  title: 'Price'
                },
                backgroundColor: '#f1f8e9',
                'width':1200,
                'height':800
              };

              var chart = new google.visualization.LineChart(document.getElementById('line_chart'));

            chart.draw(data, options);
        }

        
    }
}