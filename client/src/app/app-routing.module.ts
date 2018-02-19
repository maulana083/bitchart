import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TickerComponent } from './ticker/ticker.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TickerDetailComponent } from './ticker-detail/ticker-detail.component';

const routes:Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  {path:"tickers",component:TickerComponent},
  {path:"dashboard",component:DashboardComponent},
  {path:"detail:id",component:TickerDetailComponent},
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule],
  declarations: []
})
export class AppRoutingModule { 
  
}
