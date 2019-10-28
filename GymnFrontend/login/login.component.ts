import { Component, OnInit } from '@angular/core';
import { HandleLoginService } from '../service/handle-login.service';
import { error } from '@angular/compiler/src/util';
import { Router } from '@angular/router';

export class AdminClub {
  constructor(
    public idAdminClub: string,
    public firstNameAdminClub: string,
    public lastNameAdminClub: string,
    public loginAdminClub: string,
    public passAdminClub: string,
    public club: string,
    public logger
  ) { }
}

export class Club {
  constructor(
    public idClub: string,
    public refClub: string,
    public nameClub: string,
    public addressClub: string,
    public SumaryClub: string
  ) {

  }
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login = ''
  pass = ''
  errorMessage = ''
  private admin: AdminClub
  private club: Club

  constructor(private handleLoginService: HandleLoginService,
    private router: Router) { }

  ngOnInit() {
  }

  handleLogin() {
    this.handleLoginService.handleLoginUser(this.login, this.pass).subscribe(
      data => {
        if (data === null) {
          this.errorMessage = 'Vos identifiants sont incorrect'
        } else {
          this.admin = data
          sessionStorage.setItem('adminId', this.admin.idAdminClub)
          sessionStorage.setItem('adminFirstName', this.admin.firstNameAdminClub)
          sessionStorage.setItem('adminLastName', this.admin.lastNameAdminClub)
          this.handleLoginService.handleLoginClub(sessionStorage.getItem('adminId')).subscribe(
            data => {
              if (data === null) {

              } else {
                this.club = data
                sessionStorage.setItem('idClub', this.club.idClub)
                sessionStorage.setItem('nameClub', this.club.nameClub)
                sessionStorage.setItem('refClub', this.club.refClub)
                this.router.navigate(['welcome'])
              }
            }
          )
        }
      }
    )
  }


}
