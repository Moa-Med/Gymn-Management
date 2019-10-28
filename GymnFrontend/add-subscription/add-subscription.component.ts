import { Component, OnInit } from '@angular/core';
import { Subscriber } from '../subscriber/subscriber.component';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';
import { PerDaySubscription, PerMonthSubscription, PerThreeMonthSubscription, PerSixMonthSubscription, PerYearSubscription, Promotion, SubscriptionType } from '../add-souscription-type/add-souscription-type.component';
import { HandleSubscriptionTypeService } from '../service/handle-subscription-type.service';
import dayGridPlugin from '@fullcalendar/daygrid';
import { CalendarDataService } from '../service/calendar-data.service';
import { DatePipe } from '@angular/common';
import { Router } from '@angular/router';

export class Subscription {
  constructor(
     public idSubs: number,
    public datePaymentSubSubs: Date,
    public startDateValidSubSubs: Date,
    public endDateValidSubSubs: Date,
    //public logger: number,
    // public subscriber: number,
    // public subscriptionType: number
  ) {
  }
}

export class SubscriptionAng {
  constructor(
     public idSubs: number,
    public datePaymentSubSubs: Date,
    public startDateValidSubSubs: Date,
    public endDateValidSubSubs: Date,
    public logger: string,
    public subscriber: string,
    public subscriptionType: string,
    public price: number

  ) {
  }
}


enum ReferencePayement { dateInscription, stratOfMonth }

@Component({
  selector: 'app-add-subscription',
  templateUrl: './add-subscription.component.html',
  styleUrls: ['./add-subscription.component.css']
})
export class AddSubscriptionComponent implements OnInit {

  refOfCalcul: ReferencePayement
  subscriber: Subscriber[]
  SubscriberId: number = 0
  perDaySubscription: PerDaySubscription[]
  perMonthSubscription: PerMonthSubscription[]
  perThreeMonthSubscription: PerThreeMonthSubscription[]
  perSixMonthSubscription: PerSixMonthSubscription[]
  perYearSubscription: PerYearSubscription[]
  promotion: Promotion[]
  subscriptionType: SubscriptionType
  subscription: Subscription
  idClubUser = sessionStorage.getItem('idClub')
  calendarPlugins = [dayGridPlugin];
  calendarEvents: any[] = []
  monthSelected: string
  typeAndIdOfSouscription: string
  perDayOptiion: boolean = false
  notPerDay: boolean = false
  inscriptionDate: Date = new Date()
  whereToStart: string
  displayWhichMonth: boolean = false
  ajust: number = 0
  subscriptionExist:boolean=false
  subscriptionExistMesssage:string

  constructor(private dataFromEndOfficeService: DataFromEndOfficeService,
    private handleSubscriptionTypeService: HandleSubscriptionTypeService,
    private calendarDataService: CalendarDataService,
    private router :Router) { }

  ngOnInit() {
    this.initCalendar()
    this.subscription = new Subscription(0,new Date(), new Date(), new Date())
    this.callListSubscriber()
    this.handleSubscriptionTypeService.retrieveAllSubscriptionType()
    this.retrievePerDaySubscription()
    this.retrievePerMonthSubscription()
    this.retrievePerSixMonthSubscription()
    this.retrievePerThreeMonthSubscription()
    this.retrievePerYearSubscription()
    this.retrievePromotion()
  }

  initCalendar() {
    this.calendarDataService.getData().subscribe(
      data => this.calendarEvents = data
    )
  }
//
  handleTypeSouscription() {
    if (this.typeAndIdOfSouscription != null) {
      let typeSouscriptionOption = this.typeAndIdOfSouscription
      let type = typeSouscriptionOption.split(",", 2)[0]
      if (type === 'perDay') {
        this.notPerDay = false
        this.perDayOptiion = true
      }

      else {
        this.perDayOptiion = false
        this.notPerDay = true
      }
    }
    if(this.monthSelected != null&& this.whereToStart !=null){
      this.validationDateSubscriptions()
    }
  }

  retriveDateInscription() {
    if (this.SubscriberId != 0) {
      this.dataFromEndOfficeService.retrieveSubscriber(this.SubscriberId).subscribe(
        data => this.inscriptionDate = data.dateSubscription
      )
    }
  }

  notPerDayChoosed() {
    console.log('not PerDay click done ')
  }

  callListSubscriber() {
    let club = sessionStorage.getItem('idClub')
    this.dataFromEndOfficeService.retrieveListSubscriber(club).subscribe(
      data => this.subscriber = data
    )
  }

  addSubscription() {
    let pipe=new DatePipe("en-US")
    let logger = sessionStorage.getItem('adminId')
    let typeSouscriptionOption = this.typeAndIdOfSouscription
    let idType = typeSouscriptionOption.split(",", 2)[1]
    let type = typeSouscriptionOption.split(",", 2)[0]
    if (type === 'perDay') { this.subscription.endDateValidSubSubs = this.subscription.startDateValidSubSubs }
    this.subscriptionExist=false
    this.dataFromEndOfficeService.retriveSubscriptionBySubscriber(this.SubscriberId).subscribe(
      data=>{
        for(var _s=0;_s<data.length;_s++){
          let startDateSubscriptionSaved=pipe.transform(data[_s].startDateValidSubSubs,"yyyy-MM-dd")
          let endDateSubscriptionSaved=pipe.transform(data[_s].endDateValidSubSubs,"yyyy-MM-dd")
          let startDateSubscriptionInProgress=pipe.transform(this.subscription.startDateValidSubSubs,"yyyy-MM-dd")
          let endDateSubscriptionInProgress=pipe.transform(this.subscription.endDateValidSubSubs,"yyyy-MM-dd")
          if(startDateSubscriptionSaved===startDateSubscriptionInProgress && endDateSubscriptionSaved===endDateSubscriptionInProgress){
            this.subscriptionExist=true
            this.subscriptionExistMesssage='cette subscription existe déja'
          }
          console.log("voici les subscription : debut "+data[_s].startDateValidSubSubs+" fin : "+data[_s].endDateValidSubSubs)
        }
        if(!this.subscriptionExist){
          this.dataFromEndOfficeService.addSubscriberSubscription(parseInt(logger), this.SubscriberId, parseInt(idType), this.subscription).subscribe(
            data => this.router.navigate(['subscription'])
          )
        }
      }
    )
   
  }

  retrievePerDaySubscription() {
    this.dataFromEndOfficeService.retrievePerDaySubscription(this.idClubUser).subscribe(
      response => this.perDaySubscription = response
    )
  }

  displayMonthForm() {
    this.displayWhichMonth = true
    if(this.monthSelected != null){
      this.validationDateSubscriptions()
    }
  }

  validationDateSubscriptions() {
    let typeSouscriptionOption = this.typeAndIdOfSouscription
    let type = typeSouscriptionOption.split(",", 2)[0]
    if (type === 'perMonth') {
      this.ajust = 0
    }
    if (type === 'perThreeMonth') {
      this.ajust = 2
    }
    if (type === 'perSixMonth') {
      this.ajust = 5
    }
    if (type === 'perYear') {
      this.ajust = 11
    }
    if (type === 'promo') {
      //recupérer le nombre de mois de la promotion
      let promoId = parseInt(typeSouscriptionOption.split(",", 3)[2]) 
      this.ajust=promoId-1
    }

    if (this.whereToStart === 'startFromMonthFirstDay') {
      let yearOnString = this.monthSelected.split("-", 1)[0]
      let monthOnString = this.monthSelected.split("-", 2)[1]
      let yearOnInt = parseInt(yearOnString)
      let monthInt = parseInt(monthOnString)

      let startDate = new Date()
      startDate.setFullYear(yearOnInt)
      startDate.setMonth(monthInt - 1)
      startDate.setDate(1)

      let endMonth = new Date(yearOnInt, monthInt + this.ajust, 0)
      this.subscription.startDateValidSubSubs = startDate
      this.subscription.endDateValidSubSubs = endMonth
    }
    if (this.whereToStart === 'startFromSubscriptionDay') {
      var datePipe = new DatePipe("en-US");

      let dateInscriptionUser = this.inscriptionDate
      let dayInscription = datePipe.transform(dateInscriptionUser, 'dd');
      let dayInscriptionAsInt = parseInt(dayInscription)

      let yearOnString = this.monthSelected.split("-", 1)[0]
      let monthOnString = this.monthSelected.split("-", 2)[1]
      let yearOnInt = parseInt(yearOnString)
      let monthInt = parseInt(monthOnString)
      let startDate = new Date()
      startDate.setFullYear(yearOnInt)
      startDate.setMonth(monthInt - 1)
      startDate.setDate(dayInscriptionAsInt)
      var datePipe = new DatePipe("en-US");
      let startDateNewFormat = datePipe.transform(startDate, 'dd-MM-yyyy');
      this.subscription.startDateValidSubSubs = startDate
      console.log('la date '+startDateNewFormat)

      let endDate = new Date()
      endDate.setFullYear(yearOnInt)
      endDate.setMonth(monthInt + this.ajust)
      endDate.setDate(dayInscriptionAsInt)
      this.subscription.endDateValidSubSubs = endDate
    }
    this.calendarEvents=this.calendarDataService.showSubscriptionSelected(this.subscription.startDateValidSubSubs,this.subscription.endDateValidSubSubs)
  }

  retriveSubscriptionInCalendar(){
    this.calendarEvents=this.calendarDataService.showSubscriptionSelected(this.subscription.startDateValidSubSubs,
      this.subscription.startDateValidSubSubs)
  }

  retrievePerMonthSubscription() {
    this.dataFromEndOfficeService.retrievePerMonthSubscription(this.idClubUser).subscribe(
      response => this.perMonthSubscription = response
    )
  }



  retrievePerThreeMonthSubscription() {
    this.dataFromEndOfficeService.retrievePerThreeMonthSubscription(this.idClubUser).subscribe(
      response => this.perThreeMonthSubscription = response
    )
  }

  retrievePerSixMonthSubscription() {
    this.dataFromEndOfficeService.retrievePerSixMonthSubscription(this.idClubUser).subscribe(
      response => this.perSixMonthSubscription = response
    )
  }

  retrievePerYearSubscription() {
    this.dataFromEndOfficeService.retrievePerYearSubscription(this.idClubUser).subscribe(
      response => this.perYearSubscription = response
    )
  }

  retrievePromotion() {
    this.dataFromEndOfficeService.retrievePromotion(this.idClubUser).subscribe(
      response => this.promotion = response
    )
  }
}
