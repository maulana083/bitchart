import { Component, OnInit,Input } from '@angular/core';
import { Ticker } from '../ticker';

@Component({
  selector: 'ticker-detail',
  templateUrl: './ticker-detail.component.html',
  styleUrls: ['./ticker-detail.component.css']
})
export class TickerDetailComponent implements OnInit {
  @Input() ticker:Ticker;
  constructor() { }

  ngOnInit() {
  }

}
