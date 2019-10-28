import { Component, OnInit } from '@angular/core';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';
import { Subscription, SubscriptionAng } from '../add-subscription/add-subscription.component';
import { AdminClub } from '../login/login.component';
import { DatePipe } from '@angular/common';
import { Presence } from '../add-presence/add-presence.component';

export class SubscriptionEvent {
  constructor(
    public date: string,
    public color: string,
    public rendering: string
  ) { }
}

@Component({
  selector: 'app-list-subscription',
  templateUrl: './list-subscription.component.html',
  styleUrls: ['./list-subscription.component.css']
})
export class ListSubscriptionComponent implements OnInit {
  subscriptions: SubscriptionAng[]
  adminsClub: AdminClub[]

  constructor(private dataFromEndOfficeService: DataFromEndOfficeService) { }

  ngOnInit() {
    this.initListSubscription()
    this.retrieveAdminClub()
  }

  initListSubscription() {
    this.dataFromEndOfficeService.retrieveSubscriptionAngular(sessionStorage.getItem('idClub')).subscribe(
      data => this.subscriptions = data
    )
  }

  retrieveAdminClub() {
    this.dataFromEndOfficeService.retrieveAdminClubByClub(sessionStorage.getItem('idClub')).subscribe(
      data => {
        this.adminsClub = data
      }
    )
  }

  returnPriceSubscription(idSubscription): string {
    
    return idSubscription
  }

}
