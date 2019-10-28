import { Component, OnInit } from '@angular/core';
import { Presence, PresenceAng } from '../calendar-test/calendar-test.component';
import { DataFromEndOfficeService } from '../service/data-from-end-office.service';

@Component({
  selector: 'app-presence',
  templateUrl: './presence.component.html',
  styleUrls: ['./presence.component.css']
})
export class PresenceComponent implements OnInit {
presences:PresenceAng[]
  constructor(private dataFromEndOfficeService:DataFromEndOfficeService) { }

  ngOnInit() {
    this.retrieveAllPresences()
  }

  retrieveAllPresences(){
    let club= sessionStorage.getItem('idClub')
this.dataFromEndOfficeService.retrievePresencesAngByClub(club).subscribe(
  data=>this.presences=data
)
  }

  returnStatePresence(presence){
    return "OK"
  } 

}
