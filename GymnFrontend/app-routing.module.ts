import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RouteGuardService } from './service/route-guard.service';
import { SubscriberComponent } from './subscriber/subscriber.component';
import { LogoutComponent } from './logout/logout.component';
import { AddSubscriberComponent } from './add-subscriber/add-subscriber.component';
import { SubscriberDetailsComponent } from './subscriber-details/subscriber-details.component';
import { AddSubscriptionComponent } from './add-subscription/add-subscription.component';
import { AddSouscriptionTypeComponent } from './add-souscription-type/add-souscription-type.component';
import { SouscriptionTypeComponent } from './souscription-type/souscription-type.component';
import { CalendarTestComponent } from './calendar-test/calendar-test.component';
import { AddPresenceComponent } from './add-presence/add-presence.component';
import { ListSubscriptionComponent } from './list-subscription/list-subscription.component';
import { PresenceComponent } from './presence/presence.component';
import { ShowCalendarSubscriberComponent } from './show-calendar-subscriber/show-calendar-subscriber.component';
import { FusionChartTestComponent } from './fusion-chart-test/fusion-chart-test.component';

const routes: Routes = [
  {path:'login', component: LoginComponent},
  {path:'', component: LoginComponent},
  {path:'welcome', component: FusionChartTestComponent ,canActivate:[RouteGuardService]},
  {path:'logout', component: LogoutComponent ,canActivate:[RouteGuardService]},
  {path:'add-subscriber/:id', component: AddSubscriberComponent ,canActivate:[RouteGuardService]},
  {path:'sub-details/:id', component: SubscriberDetailsComponent ,canActivate:[RouteGuardService]},
  {path:'add-subscription', component: AddSubscriptionComponent ,canActivate:[RouteGuardService]},
  {path:'add-souscription-type', component: AddSouscriptionTypeComponent ,canActivate:[RouteGuardService]},
  {path:'subscription', component: ListSubscriptionComponent ,canActivate:[RouteGuardService]},
  {path:'souscription-type', component: SouscriptionTypeComponent ,canActivate:[RouteGuardService]},
  {path:'calendar', component: CalendarTestComponent ,canActivate:[RouteGuardService]},
  {path:'presence', component: PresenceComponent ,canActivate:[RouteGuardService]},
  {path:'add-presence', component: AddPresenceComponent ,canActivate:[RouteGuardService]},
  {path:'show-calendar/:id', component: ShowCalendarSubscriberComponent ,canActivate:[RouteGuardService]},
  {path:'fusion', component: FusionChartTestComponent ,canActivate:[RouteGuardService]},
  {path:'subscriber', component: SubscriberComponent ,canActivate:[RouteGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
