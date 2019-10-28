import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subscriber } from '../subscriber/subscriber.component';
import { API_URL } from '../app.const';
import { PerDaySubscription, PerMonthSubscription, PerThreeMonthSubscription, PerSixMonthSubscription, PerYearSubscription, Promotion } from '../add-souscription-type/add-souscription-type.component';
import { Subscription, SubscriptionAng } from '../add-subscription/add-subscription.component';
import { Presence, PresenceAng } from '../calendar-test/calendar-test.component';
import { AdminClub } from '../login/login.component';

@Injectable({
  providedIn: 'root'
})
export class DataFromEndOfficeService {

  constructor(private http :HttpClient) { }

  retrieveListSubscriber(club){
    return this.http.get<Subscriber[]>(`${API_URL}/subscribers/${club}`)
  }

  retrieveSubscriber(subscriber){
    return this.http.get<Subscriber>(`${API_URL}/subscriber/${subscriber}`)
  }

  addNewSubscriber(idClub,subscriber){
    return this.http.post(`${API_URL}/subscriber/${idClub}`,subscriber)
  }

  updateSubscriber(subscriberId,club,subscriber){
    return this.http.put(`${API_URL}/subscriber/${subscriberId}/${club}`,subscriber)
  }

  deleteSububscriber(idClub){
    return this.http.delete(`${API_URL}/subscriber/${idClub}`)
  }

  addPerDaySouscription(club,perDaySubscription){
    return this.http.post(`${API_URL}/per-day-subscription/${club}`,perDaySubscription)
  }

  addPerMonthSouscription(club,perMonthSubscription){
    return this.http.post(`${API_URL}/per-month-subscription/${club}`,perMonthSubscription)
  }

  addPerThreeMonthSouscription(club,perThreeMonthSubscription){
    return this.http.post(`${API_URL}/per-three-month-subscription/${club}`,perThreeMonthSubscription)
  }

  addPerSixMonthSouscription(club,perSixMonthSubscription){
    return this.http.post(`${API_URL}/per-six-month-subscription/${club}`,perSixMonthSubscription)
  }

  addPerYearSouscription(club,perYearSubscription){
    return this.http.post(`${API_URL}/per-year-subscription/${club}`,perYearSubscription)
  }

  addPromotion(club,promotion){
    return this.http.post(`${API_URL}/promotion/${club}`,promotion)
  }

  retrievePerDaySubscription(club){
    return this.http.get<PerDaySubscription[]>(`${API_URL}/per-day-subscription/${club}`)
  }

  retrievePerMonthSubscription(club){
    return this.http.get<PerMonthSubscription[]>(`${API_URL}/per-month-subscription/${club}`)
  }

  retrievePerThreeMonthSubscription(club){
    return this.http.get<PerThreeMonthSubscription[]>(`${API_URL}/per-three-month-subscription/${club}`)
  }

  retrievePerSixMonthSubscription(club){
    return this.http.get<PerSixMonthSubscription[]>(`${API_URL}/per-six-month-subscription/${club}`)
  }

  retrievePerYearSubscription(club){
    return this.http.get<PerYearSubscription[]>(`${API_URL}/per-year-subscription/${club}`)
  }

  retrievePromotion(club){
    return this.http.get<Promotion[]>(`${API_URL}/promotion/${club}`)
  }

  addPresence(subscriber,presence){
    return this.http.post(`${API_URL}/presence/subscriber/${subscriber}`,presence)
  }

  addSubscriberSubscription(logger,Idsubscriber,subType,subscription){
    return this.http.post(`${API_URL}/subscription/logger/${logger}/subscriber/${Idsubscriber}/subs-type/${subType}`,subscription)
  }

  retrieveSubscription(club){
    return this.http.get<Subscription[]>(`${API_URL}/subscription/club/${club}`)
  }

  retrieveSubscriptionAngular(club){
    return this.http.get<SubscriptionAng[]>(`${API_URL}/subscriptionAng/club/${club}`)
  }

  retrieveDateSubscrioptionAndIdTypeSubscription(club){
    return this.http.get<Object[]>(`${API_URL}/subscription/date-and-type/club/${club}`)
  }

  retrievePresencesByClub(club){
    return this.http.get<Presence[]>(`${API_URL}/presences/club/${club}`)
  }

  retrievePresencesAngByClub(club){
    return this.http.get<PresenceAng[]>(`${API_URL}/presencesAng/club/${club}`)
  }

  retrieveAdminClubByClub(club){
    return this.http.get<AdminClub[]>(`${API_URL}/admins-club/${club}`)
  }

  retrieveAdminClubBySubscription(idSubscription){
    return this.http.get<AdminClub>(`${API_URL}/admin-club/subscription/${idSubscription}`)
  }

  retriveSubscriptionBySubscriber(subscriber){
    return this.http.get<Subscription[]>(`${API_URL}/subscription/subscriber/${subscriber}`)
  }

  retrivePresenceBySubscriber(subscriber){
    return this.http.get<Presence[]>(`${API_URL}/presence/${subscriber}`)
  }

  reurnIdTypeSubscription(subscriptionId){
    return this.http.get<number>(`${API_URL}/subscription/id-type/${subscriptionId}`)
  }

}