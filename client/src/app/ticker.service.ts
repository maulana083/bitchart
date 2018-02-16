import { Injectable } from '@angular/core';
import { TICKERS } from './ticker-mock';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Ticker } from './ticker';
import { MessageService } from './message.service';

@Injectable()
export class TickerService {

  constructor(private messageService:MessageService) { }

  public getTickers(): Observable<Ticker[]>{
    this.messageService.add("TickerService: fetched Tickers");
    return of(TICKERS);
  }

}
