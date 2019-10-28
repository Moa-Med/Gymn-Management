import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FullCalendarModule } from '@fullcalendar/angular'; // for FullCalendar!
import { ChartsModule } from 'ng2-charts'; // for charstJs



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { MenuComponent } from './menu/menu.component';
import { WelcomeComponent } from './welcome/welcome.component';
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


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FooterComponent,
    MenuComponent,
    WelcomeComponent,
    SubscriberComponent,
    LogoutComponent,
    AddSubscriberComponent,
    SubscriberDetailsComponent,
    AddSubscriptionComponent,
    AddSouscriptionTypeComponent,
    SouscriptionTypeComponent,
    CalendarTestComponent,
    AddPresenceComponent,
    ListSubscriptionComponent,
    PresenceComponent,
    ShowCalendarSubscriberComponent,
    FusionChartTestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FullCalendarModule,
    ChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
