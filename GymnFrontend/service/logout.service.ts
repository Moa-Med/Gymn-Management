import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {

  constructor() { }

  logout() {
    sessionStorage.removeItem('adminId')
    sessionStorage.removeItem('adminFirstName')
    sessionStorage.removeItem('adminLastName')
    sessionStorage.removeItem('club')
  }
}
