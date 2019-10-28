import { Component, OnInit } from '@angular/core';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';
import { Router } from '@angular/router';

export class SubscriptionType {
  constructor(
    public idTypeSubs: number,
    public nameTypeSubs: string,
    public descTypeSubs: string,
    public pricePerDaySubscription: number,
    public pricePerMonthSubscription: number,
    public pricePerThreeMonthSubscription: number,
    public pricePerSixMonthSubscription: number,
    public pricePerYearSubscription: number,
    public nbMonth: number,
    public pricePromotion: number,
    public dateStartPromotion: Date,
    public dateEndPromotion: Date

  ) { }
}
export class PerDaySubscription {
  constructor(
    public idTypeSubs: number,
    public nameTypeSubs: string,
    public descTypeSubs: string,
    public pricePerDaySubscription: number
  ) { }
}

export class PerMonthSubscription {
  constructor(
    public idTypeSubs: number,
    public nameTypeSubs: string,
    public descTypeSubs: string,
    public pricePerMonthSubscription: number
  ) { }

}

export class PerThreeMonthSubscription {
  constructor(
    public idTypeSubs: number,
    public nameTypeSubs: string,
    public descTypeSubs: string,
    public pricePerThreeMonthSubscription: number
  ) { }
}

export class PerSixMonthSubscription {
  constructor(
    public idTypeSubs: number,
    public nameTypeSubs: string,
    public descTypeSubs: string,
    public pricePerSixMonthSubscription: number
  ) { }
}

export class PerYearSubscription {
  constructor(
    public idTypeSubs: number,
    public nameTypeSubs: string,
    public descTypeSubs: string,
    public pricePerYearSubscription: number
  ) { }
}

export class Promotion {
  constructor(
    public idTypeSubs: number,
    public nameTypeSubs: string,
    public descTypeSubs: string,
    public nbMonth: number,
    public pricePromotion: number,
    public dateStartPromotion: Date,
    public dateEndPromotion: Date
  ) { }
}


@Component({
  selector: 'app-add-souscription-type',
  templateUrl: './add-souscription-type.component.html',
  styleUrls: ['./add-souscription-type.component.css']
})
export class AddSouscriptionTypeComponent implements OnInit {
  subscriptionType: SubscriptionType
  typeSouscriptionSelected: string;
  displayPerDayFrom: boolean
  displayPerMonthForm: boolean
  displayPerThreeMonthForm: boolean
  displayPerSixMonthForm: boolean
  displayPerYearForm: boolean
  displayPromotionForm: boolean

  constructor(private dataFromEndOfficeService: DataFromEndOfficeService,
              private route: Router) { }

  ngOnInit() {
    this.subscriptionType = new SubscriptionType(0, '', '', 0, 0, 0, 0, 0, 0, 0, new Date(), new Date())
  }

  verifWhichCase() {
    if (this.typeSouscriptionSelected === '1') {
      this.displayPerDayFrom = true
      this.displayPerMonthForm = false
      this.displayPerThreeMonthForm = false
      this.displayPerSixMonthForm = false
      this.displayPerYearForm = false
      this.displayPromotionForm = false
    }
    if (this.typeSouscriptionSelected === '2') {
      this.displayPerDayFrom = false
      this.displayPerMonthForm = true
      this.displayPerThreeMonthForm = false
      this.displayPerSixMonthForm = false
      this.displayPerYearForm = false
      this.displayPromotionForm = false
    }
    if (this.typeSouscriptionSelected === '3') {
      this.displayPerDayFrom = false
      this.displayPerMonthForm = false
      this.displayPerThreeMonthForm = true
      this.displayPerSixMonthForm = false
      this.displayPerYearForm = false
      this.displayPromotionForm = false
    }

    if (this.typeSouscriptionSelected === '4') {
      this.displayPerDayFrom = false
      this.displayPerMonthForm = false
      this.displayPerThreeMonthForm = false
      this.displayPerSixMonthForm = true
      this.displayPerYearForm = false
      this.displayPromotionForm = false
    }

    if (this.typeSouscriptionSelected === '5') {
      this.displayPerDayFrom = false
      this.displayPerMonthForm = false
      this.displayPerThreeMonthForm = false
      this.displayPerSixMonthForm = false
      this.displayPerYearForm = true
      this.displayPromotionForm = false
    }
    if (this.typeSouscriptionSelected === '6') {
      this.displayPerDayFrom = false
      this.displayPerMonthForm = false
      this.displayPerThreeMonthForm = false
      this.displayPerSixMonthForm = false
      this.displayPerYearForm = false
      this.displayPromotionForm = true
    }
  }

  addSubscriptionType() {
    let clubId = sessionStorage.getItem('idClub')


    if (this.displayPerDayFrom) {
      let perDaySubscription: PerDaySubscription
      perDaySubscription=new PerDaySubscription(0,'','',0)
      perDaySubscription.nameTypeSubs = this.subscriptionType.nameTypeSubs
      perDaySubscription.descTypeSubs = this.subscriptionType.descTypeSubs
      perDaySubscription.pricePerDaySubscription = this.subscriptionType.pricePerDaySubscription
     console.log('voici lobjet '+perDaySubscription.nameTypeSubs)
      this.dataFromEndOfficeService.addPerDaySouscription(clubId, perDaySubscription).subscribe(
        data => { 
          this.route.navigate(['souscription-type'])
        }
      )

    }
    if (this.displayPerMonthForm) {
      
      let perMonthSubscription: PerMonthSubscription
      perMonthSubscription=new PerMonthSubscription(0,'','',0)
      perMonthSubscription.nameTypeSubs = this.subscriptionType.nameTypeSubs
      perMonthSubscription.descTypeSubs = this.subscriptionType.descTypeSubs
      perMonthSubscription.pricePerMonthSubscription = this.subscriptionType.pricePerMonthSubscription
      this.dataFromEndOfficeService.addPerMonthSouscription(clubId, perMonthSubscription).subscribe(
        data => {
          
            this.route.navigate(['souscription-type'])
          
        }
      )
    }
    if (this.displayPerThreeMonthForm) {
      let perThreeMonthSubscription: PerThreeMonthSubscription
      perThreeMonthSubscription=new PerThreeMonthSubscription(0,'','',0)
      perThreeMonthSubscription.nameTypeSubs = this.subscriptionType.nameTypeSubs
      perThreeMonthSubscription.descTypeSubs = this.subscriptionType.descTypeSubs
      perThreeMonthSubscription.pricePerThreeMonthSubscription = this.subscriptionType.pricePerThreeMonthSubscription
      this.dataFromEndOfficeService.addPerThreeMonthSouscription(clubId, perThreeMonthSubscription).subscribe(
        data => {
          
          this.route.navigate(['souscription-type'])
        
      }
      )
    }
    if (this.displayPerSixMonthForm) {
      let perSixMonthSubscription: PerSixMonthSubscription
      perSixMonthSubscription=new PerSixMonthSubscription(0,'','',0)
      perSixMonthSubscription.nameTypeSubs = this.subscriptionType.nameTypeSubs
      perSixMonthSubscription.descTypeSubs = this.subscriptionType.descTypeSubs
      perSixMonthSubscription.pricePerSixMonthSubscription = this.subscriptionType.pricePerSixMonthSubscription
      this.dataFromEndOfficeService.addPerSixMonthSouscription(clubId, perSixMonthSubscription).subscribe(
        data => {
          
          this.route.navigate(['souscription-type'])
        
      }
      )
    }
    if (this.displayPerYearForm) {
      let perYearSubscription: PerYearSubscription
      perYearSubscription=new PerYearSubscription(0,'','',0)
      perYearSubscription.nameTypeSubs = this.subscriptionType.nameTypeSubs
      perYearSubscription.descTypeSubs = this.subscriptionType.descTypeSubs
      perYearSubscription.pricePerYearSubscription = this.subscriptionType.pricePerYearSubscription
      this.dataFromEndOfficeService.addPerYearSouscription(clubId, perYearSubscription).subscribe(
        data => {
          
          this.route.navigate(['souscription-type'])
        
      }
      )
    }
    if (this.displayPromotionForm) {
      let promotion: Promotion
      promotion=new Promotion(0,'','',0,0,new Date(),new Date())
      promotion.nameTypeSubs = this.subscriptionType.nameTypeSubs
      promotion.descTypeSubs = this.subscriptionType.descTypeSubs
      promotion.pricePromotion = this.subscriptionType.pricePromotion
      promotion.nbMonth = this.subscriptionType.nbMonth
      promotion.dateStartPromotion = this.subscriptionType.dateStartPromotion
      promotion.dateEndPromotion = this.subscriptionType.dateEndPromotion
      this.dataFromEndOfficeService.addPromotion(clubId, promotion).subscribe(
        data => {
          
          this.route.navigate(['souscription-type'])
        
      }
      )
    }

  }


}
