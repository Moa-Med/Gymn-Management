import { Component, OnInit } from '@angular/core';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';
import { PerDaySubscription, PerMonthSubscription, PerThreeMonthSubscription, PerSixMonthSubscription, PerYearSubscription, Promotion } from '../add-souscription-type/add-souscription-type.component';
import { HandleSubscriptionTypeService } from '../service/handle-subscription-type.service';

@Component({
  selector: 'app-souscription-type',
  templateUrl: './souscription-type.component.html',
  styleUrls: ['./souscription-type.component.css']
})
export class SouscriptionTypeComponent implements OnInit {

  constructor(private dataFromEndOfficeService : DataFromEndOfficeService,
    private handleSubscriptionTypeService: HandleSubscriptionTypeService) { }
  perDaySubscription:PerDaySubscription[]
  perMonthSubscription:PerMonthSubscription[]
  perThreeMonthSubscription:PerThreeMonthSubscription[]
  perSixMonthSubscription:PerSixMonthSubscription[]
  perYearSubscription:PerYearSubscription[]
  promotion:Promotion[]

  messageDel:string
  idClubUser=sessionStorage.getItem('idClub')

  ngOnInit() {

    this.handleSubscriptionTypeService.retrieveAllSubscriptionType()
    this.retrievePerDaySubscription()
    this.retrievePerMonthSubscription()
    this.retrievePerSixMonthSubscription()
    this.retrievePerThreeMonthSubscription()
    this.retrievePerYearSubscription()
    this.retrievePromotion()

  }

  retrievePerDaySubscription(){
    this.dataFromEndOfficeService.retrievePerDaySubscription(this.idClubUser).subscribe(
      response=>this.perDaySubscription=response
    )
  }

  retrievePerMonthSubscription(){
    this.dataFromEndOfficeService.retrievePerMonthSubscription(this.idClubUser).subscribe(
      response=>this.perMonthSubscription=response
    )
  }

  retrievePerThreeMonthSubscription(){
    this.dataFromEndOfficeService.retrievePerThreeMonthSubscription(this.idClubUser).subscribe(
      response=>this.perThreeMonthSubscription=response
    )
  }

  retrievePerSixMonthSubscription(){
    this.dataFromEndOfficeService.retrievePerSixMonthSubscription(this.idClubUser).subscribe(
      response=>this.perSixMonthSubscription=response
    )
  }

  retrievePerYearSubscription(){
    this.dataFromEndOfficeService.retrievePerYearSubscription(this.idClubUser).subscribe(
      response=>this.perYearSubscription=response
    )
  }

  retrievePromotion(){
    this.dataFromEndOfficeService.retrievePromotion(this.idClubUser).subscribe(
      response=>this.promotion=response
    )
  }
}
