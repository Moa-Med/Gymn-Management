import { Component, OnInit } from '@angular/core';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';
import { Router } from '@angular/router';

export class Subscriber {
  constructor(
    public idSub: number,
    public firstNameSub: string,
    public lastNameSub: string,
    public dateSubscription: Date,
    public ageSub: number,
    public weightSub: number,
    public heightSub: number,
    public sizeSub: string

  ) { }
}

@Component({
  selector: 'app-subscriber',
  templateUrl: './subscriber.component.html',
  styleUrls: ['./subscriber.component.css']
})
export class SubscriberComponent implements OnInit {
  clubId = sessionStorage.getItem('idClub')
  subscribers: Subscriber[]
  messageDel:string

  constructor(private dataFromEndOfficeService: DataFromEndOfficeService,
    private router: Router) { }

  ngOnInit() {
    this.retrieveAllSubs()
  }

  retrieveAllSubs() {
    this.dataFromEndOfficeService.retrieveListSubscriber(this.clubId).subscribe(
      response => {
        if (response != null) {
          this.subscribers = response
        }
        else {

        }
      }
    )
  }

  addSubscriber() {
    this.router.navigate(['add-subscriber',-1])
  }

  updateSub(idSubscriber){
    this.router.navigate(['add-subscriber',idSubscriber])
  }

  deleteSub(idSub){
    this.dataFromEndOfficeService.deleteSububscriber(idSub).subscribe(
      response=>{
        this.messageDel='suppression effectué !!'
        this.retrieveAllSubs()
        console.log(response)
      }
    )
  }

  detailSub(idSubscriber){
    this.router.navigate(['sub-details',idSubscriber])
  }

  showCalendarSubscriber(idSubscriber){
    this.router.navigate(['show-calendar',idSubscriber])
  }

}
