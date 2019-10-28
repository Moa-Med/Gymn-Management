import { Component, OnInit, ViewChild } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import { CalendarDataService } from '../service/calendar-data.service';
import { Subscriber } from '../subscriber/subscriber.component';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { FullCalendarComponent } from '@fullcalendar/angular';
import { Subscription } from '../add-subscription/add-subscription.component';

export class PresenceEvent {
  constructor(
    public date: string,
    public color: string
  ) { }
}
//
export class Presence {
  constructor(
    public idPresence: number,
    public datePresence: Date,
    public note: string,
    public subscriber: number
  ) {
  }
}

@Component({
  selector: 'app-add-presence',
  templateUrl: './add-presence.component.html',
  styleUrls: ['./add-presence.component.css']
})
export class AddPresenceComponent implements OnInit {
  subscriber: Subscriber[] = []
  subscription: Subscription[] = []
  UserPresence: Presence[] = []
  idSubscriber: number = 0
  presence: Presence = new Presence(0, new Date(), '', 0)
  calendarPlugins = [dayGridPlugin]
  calendarEvents: any[] = []
  calendarEvents1: any[] = []
  addPresenceSuccess: string = ''
  presenceEvent: Array<PresenceEvent> = [];
  pipe = new DatePipe('en-US')
  presenceExist:boolean=false
  presenceExistMessage:string
  //@ViewChild('calendar') calendarComponent: FullCalendarComponent
  //@ViewChild('calendar') calendar: FullCalendarComponent;

  constructor(private calendarDataService: CalendarDataService,
    private dataFromEndOfficeService: DataFromEndOfficeService,
    private route: Router) { }

  ngOnInit() {

    this.callListSubscriber()
    this.retrieveSubscription()
  }

  initCalendar() {
    this.calendarDataService.getData().subscribe(
      data => this.calendarEvents = data
    )
  }

  retrievePresencesAndSubscriptions() {
    let listSubscription:Subscription[]=[]
    let listPresence:Presence[]=[]

    this.calendarDataService.getPresencebyUser(this.idSubscriber).subscribe(
      data => {
        listPresence = data
        this.calendarDataService.retrieveSubscriptionSub(this.idSubscriber).subscribe(
          data => {
            listSubscription = data
        this.calendarEvents1 = this.calendarDataService.retrieveSubscriptionCalendarAndPresenceStatus(listSubscription,this.presence.datePresence);
          }
        )
      }
    )
  }

  retrievePresences() {
    this.calendarDataService.getPresencebyUser(this.idSubscriber).subscribe(
      data => {
        this.UserPresence = data
    this.calendarEvents1 = this.calendarDataService.retrieveCalendarEvents(this.subscription, this.UserPresence);
      }
    )
  }

  retrieveSubscriptionSub() {
    this.calendarDataService.retrieveSubscriptionSub(this.idSubscriber).subscribe(
      data => {
        this.subscription = data
      }
    )
  }

  callListSubscriber() {
    let club = sessionStorage.getItem('idClub')
    this.dataFromEndOfficeService.retrieveListSubscriber(club).subscribe(
      data => this.subscriber = data
    )
  }

  addPresence() {
    let pipe=new DatePipe("en-US")

    this.dataFromEndOfficeService.retrivePresenceBySubscriber(this.idSubscriber).subscribe(
      data=>{
        this.presenceExist=false
        for (var _p=0;_p<data.length;_p++){
        let presenceSaved = pipe.transform(data[_p].datePresence,"yyy-MM-dd")
        let presenceInProgress=pipe.transform(this.presence.datePresence,"yyy-MM-dd")
        
        if(presenceSaved===presenceInProgress){
          this.presenceExist=true
          this.presenceExistMessage='Attention! cette présence a déja été enregistré'
        }
        console.log("la liste des presence "+presenceSaved)
        console.log("voici la presence en cours "+presenceInProgress)

        }
        if (!this.presenceExist){
    this.dataFromEndOfficeService.addPresence(this.idSubscriber, this.presence).subscribe(data => this.route.navigate(['presence']))
        }
      }
      
    )
  }

  retrieveSubscription() {
    this.calendarDataService.retrieveSubscription(sessionStorage.getItem('idClub')).subscribe(
      data => {
        this.subscription = data
      }
    )
  }

}
