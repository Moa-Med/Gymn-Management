import { Component, OnInit } from '@angular/core';
import { HandleLoginService } from '../service/handle-login.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  firstName:string
  lastName:string
  nameClub:string

  constructor( private handleLoginService : HandleLoginService) { }

  ngOnInit() {
    this.firstName=sessionStorage.getItem('adminFirstName')
    this.lastName=sessionStorage.getItem('adminLastName')
    this.nameClub=sessionStorage.getItem('nameClub')
  }



}
