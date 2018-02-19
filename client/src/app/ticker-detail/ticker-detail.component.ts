import { Component, OnInit,Input } from '@angular/core';
import { Ticker } from '../ticker';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { TickerService } from '../ticker.service';

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
  }

  getTicker():void{
    const id = this.route.snapshot.paramMap.get('id');
    this.tickerService.getTicker(id).subscribe(ticker=>this.ticker=ticker);
  }

  goBack(): void {
    this.location.back();
  }
}
