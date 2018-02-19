import { Component, OnInit,Input } from '@angular/core';
import { Ticker } from '../ticker';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { TickerService } from '../ticker.service';
declare var google:any;
@Component({
  selector: 'ticker-detail',
  templateUrl: './ticker-detail.component.html',
  styleUrls: ['./ticker-detail.component.css']
})
export class TickerDetailComponent implements OnInit {
  @Input() ticker:Ticker;
  constructor(private route:ActivatedRoute, 
              private location:Location, 
              private tickerService:TickerService
  ) { }

  ngOnInit() {
    this.getTicker();
    this.drawChart();
  }

  getTicker():void{
    const id = this.route.snapshot.paramMap.get('id');
    this.tickerService.getTicker(id).subscribe(ticker=>this.ticker=ticker);
  }

  goBack(): void {
    this.location.back();
  }

  drawChart():void{
      google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

      var data = google.visualization.arrayToDataTable([
        ['Task', 'Hours per Day'],
        ['Work',     11],
        ['Eat',      2],
        ['Commute',  2],
        ['Watch TV', 2],
        ['Sleep',    7]
      ]);

      var options = {
        title: 'My Daily Activities'
      };

      var chart = new google.visualization.PieChart(document.getElementById('chart_div'));

      chart.draw(data, options);
    }
  }

  drawCandleStickChart():void{
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

      var data = google.visualization.arrayToDataTable([
        ['Task', 'Hours per Day'],
        ['Work',     11],
        ['Eat',      2],
        ['Commute',  2],
        ['Watch TV', 2],
        ['Sleep',    7]
      ]);

      var options = {
        title: this.ticker.name
      };

      var chart = new google.visualization.CandlestickChart(document.getElementById('chart_div_1'));

      chart.draw(data, options);
  }
}
}
