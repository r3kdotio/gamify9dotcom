import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { Location } from '@angular/common';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

/* modified version of solution here: https://stackoverflow.com/q/39641554/338249 */

@Injectable()
export class AuthenticationCallbackActivateGuard implements CanActivate {


  constructor(private router: Router, private location: Location) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) { return true }
  //   var path = this.location.path(true);

  //   // You may want to make a more robust check here
  //   var isAuthenticationCallback = path.indexOf("access_token") !== -1;

  //   if (isAuthenticationCallback) {
  //     let url_string = "http://gamify9.com/?" + path;
  //     let url = new URL(url_string);
  //     let id_token = url.searchParams.get("id_token");
  //     let access_token = url.searchParams.get("access_token");
  //     //let expiresIn = url.searchParams.get('expiresIn');
  //   const expiresAt = JSON.stringify(new Date().getTime() + 10000);
  //   localStorage.setItem('access_token', access_token);
  //   localStorage.setItem('id_token', id_token);
  //   localStorage.setItem('expires_at', expiresAt);


  //     console.info("path is " + path);
  //     console.info("access_token " + id_token);
  //     this.router.navigate(['dashboard']);

  //     return false;
  //   }

  //   return true;
  // }
}
