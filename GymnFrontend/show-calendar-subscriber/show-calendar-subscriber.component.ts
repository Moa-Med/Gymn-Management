import { Component, OnInit } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import { Subscription } from '../add-subscription/add-subscription.component';
import { Presence } from '../add-presence/add-presence.component';
import { CalendarDataService } from '../service/calendar-data.service';
import { Route, ActivatedRoute } from '@angular/router';
import { CanActivate } from '@angular/router/src/utils/preactivation';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';
import { Subscriber } from '../subscriber/subscriber.component';

@Component({
  selector: 'app-show-calendar-subscriber',
  templateUrl: './show-calendar-subscriber.component.html',
  styleUrls: ['./show-calendar-subscriber.component.css']
})
export class ShowCalendarSubscriberComponent implements OnInit {
  calendarPlugins = [dayGridPlugin];
  subsciber:Subscriber
  calendarEvents: any[] = []
  firstNameSubscriber:string=''
  lastNameSubscriber:string=''



  constructor(private calendarDataService: CalendarDataService,
              private dataFromEndOfficeService: DataFromEndOfficeService,
              private route:ActivatedRoute) { }

  ngOnInit() {
    this.retrievePresencesAndSubscriptions()
    this.retriveInfoSubscriber()
  }

  retrievePresencesAndSubscriptions() {
    let listSubscription:Subscription[]=[]
    let listPresence:Presence[]=[]
    this.calendarDataService.getPresencebyUser(this.route.snapshot.params['id']).subscribe(
      data => {
        listPresence = data
        this.calendarDataService.retrieveSubscriptionSub(this.route.snapshot.params['id']).subscribe(
          data => {
            listSubscription = data
        this.calendarEvents = this.calendarDataService.retrieveCalendarEvents(listSubscription, listPresence);
          }
        )
      }
    )
  }

  retriveInfoSubscriber(){
    this.dataFromEndOfficeService.retrieveSubscriber(this.route.snapshot.params['id']).subscribe(
      data=> {
        this.firstNameSubscriber=data.firstNameSub
        this.lastNameSubscriber=data.lastNameSub
      }
    )
  }

  returnSubscriberInfo(){
    return this.firstNameSubscriber+' '+this.lastNameSubscriber
  }

}
