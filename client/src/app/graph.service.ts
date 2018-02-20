import { Injectable } from '@angular/core';
import { API_URL } from './ticker-mock';
import { TimeFrame } from './timeframe';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class GraphService {
  graphUrl=API_URL+"/graph/";
  constructor(private httpClient:HttpClient) { } 

  public getGraphData(id,unit,scale):Observable<TimeFrame[]>{
    console.log(this.graphUrl+id+"?unit="+unit+"&scale="+scale);
    return this.httpClient.get<TimeFrame[]>(this.graphUrl+id+"?unit="+unit+"&scale="+scale);
  }

}
