import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { HandleLoginService } from './handle-login.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate{

  constructor(private handleLoginService : HandleLoginService,
              private router : Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if (this.handleLoginService.isLogged())return true
    this.router.navigate([''])
    return false
  }
}
