import { Component, OnInit } from '@angular/core';
import { Ticker } from '../ticker';
import { TickerService } from '../ticker.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  private tickers : Ticker[];
  constructor(private tickerService:TickerService) { }

  ngOnInit() {
    this.getTickers();
  }

  getTickers(){
    this.tickerService.getTickers().subscribe(t=>this.tickers=t.slice(1,5
    ));
  }

}
