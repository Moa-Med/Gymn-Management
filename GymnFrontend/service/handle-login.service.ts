import { Injectable } from '@angular/core';
import { AdminClub, Club } from '../login/login.component';
import { HttpClient } from '@angular/common/http';
import { API_URL } from '../app.const';

@Injectable({
  providedIn: 'root'
})
export class HandleLoginService {

  constructor(private htttp: HttpClient) { }

  handleLoginUser(login, pass){
    return  this.htttp.get<AdminClub>(`${API_URL}/login/${login}/${pass}`)
  }

  handleLoginClub(adminId){
    return  this.htttp.get<Club>(`${API_URL}/admin-club/${adminId}`)
  }

  isLogged(){
    let user = sessionStorage.getItem('adminId')
    return !(user === null)
  }

  getClubName(){
    return sessionStorage.getItem('nameClub')
  }

  getUserConnected(){
    return sessionStorage.getItem('adminFirstName')+' '+sessionStorage.getItem('adminLastName')
  }

}
