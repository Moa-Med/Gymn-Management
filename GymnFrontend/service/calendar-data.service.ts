import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from '../app.const';
import { DatePipe } from '@angular/common';
import { SubscriptionEvent } from '../list-subscription/list-subscription.component';
import { Subscription } from '../add-subscription/add-subscription.component';
import { Presence } from '../add-presence/add-presence.component';
import { DataFromEndOfficeService } from './data-from-end-office.service';

@Injectable({
  providedIn: 'root'
})
export class CalendarDataService {
  subscription: Subscription[]
  

  constructor(private http: HttpClient,
    private dataFromEndOfficeService: DataFromEndOfficeService) { }
  getData(): Observable<any[]> {
    return this.http.get<any[]>('api/events.json')
  }
  getPresencebyUser(user) {
    return this.http.get<Presence[]>(`${API_URL}/presence/${user}`)

  }

  retrieveSubscriptionSub(subscriber) {
    return this.http.get<Subscription[]>(`${API_URL}/subscription/subscriber/${subscriber}`)
  }

  retrieveSubscription(club) {
    return this.http.get<Subscription[]>(`${API_URL}/subscription/club/${club}`)
  }

  retrieveCalendarEvents(subscription: Subscription[], presence: Presence[]): any[] {
    let pipe = new DatePipe('en-US')
    let subscriptionEvent: SubscriptionEvent[] = []
    let redPresenceArray: string[] = []
    let greenPresenceArray: string[] = []
    let nbSubs = subscription.length
    let nbPresence = presence.length
    let listPresenceAsString: string[] = []

    for (var i = 0; i < nbPresence; i++) {
      let datePresence = pipe.transform(presence[i].datePresence, 'yyyy-MM-dd')
      listPresenceAsString.push(datePresence)
    }
    redPresenceArray = listPresenceAsString

    for (var y = 0; y < nbSubs; y++) {
      let initialDateAsDate = new Date(subscription[y].startDateValidSubSubs)
      let lastDateAsDate = new Date(subscription[y].endDateValidSubSubs)
      let initialDate = initialDateAsDate.getDate()
      let initialMonth = initialDateAsDate.getMonth()
      let initialYear = initialDateAsDate.getFullYear()
      let dif = lastDateAsDate.getTime() - initialDateAsDate.getTime()
      let difAsDay = Math.ceil(dif / (1000 * 60 * 60 * 24))

      for (var z = 0; z < difAsDay + 1; z++) {
        let oneDate = new Date()
        oneDate.setFullYear(initialYear)
        oneDate.setMonth(initialMonth)
        oneDate.setDate(initialDate + z)
        let dateEvent = pipe.transform(oneDate, 'yyyy-MM-dd')
        subscriptionEvent.push(new SubscriptionEvent(dateEvent, '#0B3B17', 'background'))

        let lengthPrensence = listPresenceAsString.length
        for (var x = 0; x < lengthPrensence; x++) {
          if (dateEvent === listPresenceAsString[x]) {
            subscriptionEvent.push(new SubscriptionEvent(dateEvent, '#31B404', ''))
            greenPresenceArray.push(dateEvent)
            redPresenceArray.splice(x, 1)
          }
        }
      }
    }
    for (var l = 0; l < redPresenceArray.length; l++) {
      let redPresence = redPresenceArray[l]
      subscriptionEvent.push(new SubscriptionEvent(redPresence, '#FF0000', ''))
    }
    return subscriptionEvent
  }

  showSubscriptionSelected(startDateSubscription: Date, endDateSubscription: Date): any[] {
    let pipe = new DatePipe('en-US')
    let dateTest: Date
    let subscriptionEvent: SubscriptionEvent[] = []

    let initialDateAsDate = new Date(startDateSubscription)
    let lastDateAsDate = new Date(endDateSubscription)
    let initialDate = initialDateAsDate.getDate()
    let initialMonth = initialDateAsDate.getMonth()
    let initialYear = initialDateAsDate.getFullYear()
    let dif = lastDateAsDate.getTime() - initialDateAsDate.getTime()
    let difAsDay = Math.ceil(dif / (1000 * 60 * 60 * 24))

    for (var z = 0; z < difAsDay + 1; z++) {
      let oneDate = new Date()
      oneDate.setFullYear(initialYear)
      oneDate.setMonth(initialMonth)
      oneDate.setDate(initialDate + z)
      let dateEvent = pipe.transform(oneDate, 'yyyy-MM-dd')
      subscriptionEvent.push(new SubscriptionEvent(dateEvent, '#0B3B17', 'background'))
    }
    return subscriptionEvent
  }

  retrieveSubscriptionCalendarAndPresenceStatus(subscription: Subscription[], dateSelected: Date): any[] {
    let pipe = new DatePipe('en-US')
    let subscriptionEvent: SubscriptionEvent[] = []
    let redPresenceArray: string[] = []
    let greenPresenceArray: string[] = []
    let nbSubs = subscription.length
    let listPresenceAsString: string[] = []
    let finalDateSelectedString: string = ''
    let verificationDateSelected: boolean = false

    if (nbSubs === 0) {
      let dateSelectedAsDate = new Date(dateSelected)
      let finalDateSelected = new Date()
      finalDateSelected.setDate(dateSelectedAsDate.getDate())
      finalDateSelected.setMonth(dateSelectedAsDate.getMonth())
      finalDateSelected.setFullYear(dateSelectedAsDate.getFullYear())
      finalDateSelectedString = pipe.transform(finalDateSelected, 'yyyy-MM-dd')

      subscriptionEvent.push(new SubscriptionEvent(finalDateSelectedString, '#FF0000', 'background'))
    }

    for (var y = 0; y < nbSubs; y++) {
      let initialDateAsDate = new Date(subscription[y].startDateValidSubSubs)
      let lastDateAsDate = new Date(subscription[y].endDateValidSubSubs)
      let initialDate = initialDateAsDate.getDate()
      let initialMonth = initialDateAsDate.getMonth()
      let initialYear = initialDateAsDate.getFullYear()
      let dif = lastDateAsDate.getTime() - initialDateAsDate.getTime()
      let difAsDay = Math.ceil(dif / (1000 * 60 * 60 * 24))

      for (var z = 0; z < difAsDay + 1; z++) {
        let oneDate = new Date()
        oneDate.setFullYear(initialYear)
        oneDate.setMonth(initialMonth)
        oneDate.setDate(initialDate + z)
        let dateEvent = pipe.transform(oneDate, 'yyyy-MM-dd')
        subscriptionEvent.push(new SubscriptionEvent(dateEvent, '#0B3B17', 'background'))

        let dateSelectedAsDate = new Date(dateSelected)
        let finalDateSelected = new Date()
        finalDateSelected.setDate(dateSelectedAsDate.getDate())
        finalDateSelected.setMonth(dateSelectedAsDate.getMonth())
        finalDateSelected.setFullYear(dateSelectedAsDate.getFullYear())
        finalDateSelectedString = pipe.transform(finalDateSelected, 'yyyy-MM-dd')

        if (dateEvent === finalDateSelectedString) {
          subscriptionEvent.push(new SubscriptionEvent(finalDateSelectedString, '#31B404', 'background'))
          verificationDateSelected = true
        }
      }
    }

    if (verificationDateSelected === false) {
      subscriptionEvent.push(new SubscriptionEvent(finalDateSelectedString, '#FF0000', 'background'))
    }
    return subscriptionEvent
  }

  ///////////////////////////////////////////////////////////////////////////////////

  checkIfUserIsReglo(subscription: Subscription[], presence: Presence[]): boolean {
    let pipe = new DatePipe('en-US')
    let redPresenceArray: string[] = []
    let nbSubs = subscription.length
    let nbPresence = presence.length
    let listPresenceAsString: string[] = []

    for (var i = 0; i < nbPresence; i++) {
      let datePresence = pipe.transform(presence[i].datePresence, 'yyyy-MM-dd')
      listPresenceAsString.push(datePresence)
    }
    redPresenceArray = listPresenceAsString

    if (nbSubs === 0 && nbPresence != 0) {
      return false
    }

    if (nbSubs === 0 && nbPresence === 0) {
      return true
    }

    for (var y = 0; y < nbSubs; y++) {
      let initialDateAsDate = new Date(subscription[y].startDateValidSubSubs)
      let lastDateAsDate = new Date(subscription[y].endDateValidSubSubs)
      let initialDate = initialDateAsDate.getDate()
      let initialMonth = initialDateAsDate.getMonth()
      let initialYear = initialDateAsDate.getFullYear()
      let dif = lastDateAsDate.getTime() - initialDateAsDate.getTime()
      let difAsDay = Math.ceil(dif / (1000 * 60 * 60 * 24))

      for (var z = 0; z < difAsDay + 1; z++) {
        let oneDate = new Date()
        oneDate.setFullYear(initialYear)
        oneDate.setMonth(initialMonth)
        oneDate.setDate(initialDate + z)

        let dateEvent = pipe.transform(oneDate, 'yyyy-MM-dd')
        let lengthPrensence = listPresenceAsString.length

        for (var x = 0; x < lengthPrensence; x++) {
          if (dateEvent === listPresenceAsString[x]) {
            //console.log("element supprimé " + listPresenceAsString[x])
            redPresenceArray.splice(x, 1)
          }
        }
      }
    }

    for (var l = 0; l < redPresenceArray.length; l++) {
      let redPresence = redPresenceArray[l]
      //console.log("voici la présence " + redPresence)
    }

    //console.log("la taille est " + redPresenceArray.length)

    if (redPresenceArray.length === 0) {
      redPresenceArray = []
      return true
    }
    redPresenceArray = []
    return false
  }
}



