import { Component, OnInit } from '@angular/core';
import { Subscriber } from '../subscriber/subscriber.component';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-subscriber',
  templateUrl: './add-subscriber.component.html',
  styleUrls: ['./add-subscriber.component.css']
})
export class AddSubscriberComponent implements OnInit {
subscriber:Subscriber
action:number
addOrUpdate:string
  constructor(private dataFromEndOfficeService: DataFromEndOfficeService,
    private router:Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.subscriber=new Subscriber(1,'','',new Date(),0,0,0,'')
    this.action=this.route.snapshot.params['id']
    if(this.action != -1){
      this.addOrUpdate='Modifier'
      this.displaySubscriberdata()
    }else{
      this.addOrUpdate='Ajouter'
    }
  }

  displaySubscriberdata(){
    this.dataFromEndOfficeService.retrieveSubscriber(this.action).subscribe(
      data=>this.subscriber=data
    )
  }

  addOrUpdateSubscriber(){
    if(this.action != -1){
      let club=sessionStorage.getItem('idClub')
      console.log(this.subscriber.dateSubscription)
     this.dataFromEndOfficeService.updateSubscriber(this.action,club,this.subscriber).subscribe(
       data=>this.router.navigate(['subscriber'])
     )
    }else{
      let club=sessionStorage.getItem('idClub')
   this.dataFromEndOfficeService.addNewSubscriber(club,this.subscriber).subscribe(
     data=>this.router.navigate(['subscriber'])
   )
    }
   
  }

}
