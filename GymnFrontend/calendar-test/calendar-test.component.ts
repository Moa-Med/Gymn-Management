import { Component, OnInit } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import { CalendarDataService } from '../service/calendar-data.service';
import { Options } from 'selenium-webdriver';
import { Subscriber } from '../subscriber/subscriber.component';
import { DatePipe } from '@angular/common';

export class PresenceEvent{
  constructor(
    public date : string,
    public color:string
  ){}
}

export class Presence{
  constructor(
    public idPresence : number,
    public datePresence : Date,
    public note : string,
    public subscriber : number
  ){
  }
}

export class PresenceAng{
  constructor(
    public idPresence : number,
    public datePresence : Date,
    public note : string,
    public subscriber : string,
    public isReglo: boolean
  ){
  }
}

@Component({
  selector: 'app-calendar-test',
  templateUrl: './calendar-test.component.html',
  styleUrls: ['./calendar-test.component.css']
})
export class CalendarTestComponent implements OnInit {
  calendarPlugins = [dayGridPlugin];
  calendarEvents:any[]=[]
  UserPresence:Presence[]=[]
  UserPresence1:any[]=[]
  presenceEvent:Array<PresenceEvent> = [];
  pipe = new DatePipe('en-US')
  constructor(private calendarDataService:CalendarDataService) { }
 

  ngOnInit() {
    //this.initCalendar()
    //this.retrieveUserPresence()

    let dateStrart=new Date()
    let test='ab'==='ab'
    console.log('le test  '+test)
    //console.log('la date debut '+dateStrart.getDay())
    
  }

  initCalendar(){
    this.calendarDataService.getData().subscribe(
      data=>{
        this.calendarEvents=data
      }
    )
  }
  eventClick(model) {
    console.log(model);
  }

  retrieveUserPresence(){
    this.calendarDataService.getPresencebyUser(4).subscribe(
      data=>{
        this.UserPresence=data
        for(var i=0;i<this.UserPresence.length;i++){
          let dateEvent=this.pipe.transform(this.UserPresence[i].datePresence, 'yyyy-MM-dd')
          this.presenceEvent.push(new PresenceEvent(dateEvent,"#FF0000"))
        }
        this.UserPresence1=this.presenceEvent
      }
    )
  }

  
}
