import { Component, OnInit } from '@angular/core';
import { Subscriber } from '../subscriber/subscriber.component';
import { ActivatedRoute, Router } from '@angular/router';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';

@Component({
  selector: 'app-subscriber-details',
  templateUrl: './subscriber-details.component.html',
  styleUrls: ['./subscriber-details.component.css']
})
export class SubscriberDetailsComponent implements OnInit {
  subscriber: Subscriber
  constructor(private dataFromEndOfficeService: DataFromEndOfficeService,
    private route: ActivatedRoute, private router:Router) { }

  ngOnInit() {
    let idSubscriber = this.route.snapshot.params['id']
    this.dataFromEndOfficeService.retrieveSubscriber(idSubscriber).subscribe(
      data=>this.subscriber=data
    )
    
  }
  backToListSubsciber(){
    this.router.navigate(['subscriber'])
  }
}