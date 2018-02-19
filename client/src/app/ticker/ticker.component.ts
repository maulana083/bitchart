import { Component, OnInit } from '@angular/core';
import { Ticker } from '../ticker';
import { TickerService } from '../ticker.service';
@Component(
  {
    selector:'ticker',
    templateUrl:'./ticker.component.html',
    styleUrls: ['./ticker.component.css']
  }
)
export class TickerComponent implements OnInit{
  tickers : Ticker[];
  tickerService:TickerService;

  constructor(_tickerService:TickerService){
    this.tickerService=_tickerService;
  }

  ngOnInit(){
    this.goTickers();
  }
  
  goTickers(){
    this.tickerService.getTickers().subscribe(tickers => this.tickers=tickers);
  }
}
