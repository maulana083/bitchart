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
  title='ticker component';
  tickers : Ticker[];
  selectedTicker:Ticker;
  tickerService:TickerService;
  ticker : Ticker = {
    id :1,
    name:"bitcoin",
    priceUsd:8000
  };

  constructor(_tickerService:TickerService){
    this.tickerService=_tickerService;
  }

  ngOnInit(){
    this.goTickers();
  }

  onSelect(ticker){
    this.selectedTicker=ticker;
    console.log("selected ticker:"+ticker.name);
  }

  goTickers(){
    this.tickerService.getTickers().subscribe(tickers => this.tickers=tickers);
  }
}
