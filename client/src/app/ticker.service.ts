import { Injectable } from '@angular/core';
import { TICKERS, API_URL } from './ticker-mock';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Ticker } from './ticker';
import { MessageService } from './message.service';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class TickerService {
  private tickersUrl=API_URL+"/tickers";

  constructor(private httpClient:HttpClient, private messageService:MessageService) { }

  public getTickers(): Observable<Ticker[]>{
    this.messageService.add("TickerService: fetched Tickers");
    return this.httpClient.get<Ticker[]>(this.tickersUrl);
  }

}
