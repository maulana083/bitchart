import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { TickerComponent } from './ticker/ticker.component';
import { TickerDetailComponent } from './ticker-detail/ticker-detail.component';
import { TickerService } from './ticker.service';
import { MessagesComponent } from './messages/messages.component';
import { MessageService } from './message.service';
import { AppRoutingModule } from './/app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    TickerComponent,
    TickerDetailComponent,
    MessagesComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [TickerService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
