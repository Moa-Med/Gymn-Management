import { Injectable } from '@angular/core';
import { DataFromEndOfficeService } from './data-from-end-office.service';
import { PerDaySubscription, PerMonthSubscription, PerThreeMonthSubscription, PerSixMonthSubscription, PerYearSubscription, Promotion } from '../add-souscription-type/add-souscription-type.component';

@Injectable({
  providedIn: 'root'
})
export class HandleSubscriptionTypeService {
  perDaySubscription:PerDaySubscription[]
  perMonthSubscription:PerMonthSubscription[]
  perThreeMonthSubscription:PerThreeMonthSubscription[]
  perSixMonthSubscription:PerSixMonthSubscription[]
  perYearSubscription:PerYearSubscription[]
  promotion:Promotion[]
  idClubUser=sessionStorage.getItem('idClub')

  constructor(private dataFromEndOfficeService: DataFromEndOfficeService) { }

  retrieveAllSubscriptionType(){
    this.retrievePerDaySubscription()
    this.retrievePerMonthSubscription()
    this.retrievePerSixMonthSubscription()
    this.retrievePerThreeMonthSubscription()
    this.retrievePerYearSubscription()
    this.retrievePromotion()
  }

  retrievePerDaySubscription(){
    let perDaySubscription:PerDaySubscription[]
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
