import { tap, delay } from 'rxjs/operators';
import { Injectable, EventEmitter } from '@angular/core';
import { User } from './user';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn(isLoggedIn: any) {
      throw new Error('Method not implemented.');
  }
  token: any = [];
  logstatus: any = new EventEmitter<string>();

  login(user: Object): Observable<boolean> {
    const loginUrl = ''; // Fill in the URL for the login endpoint

    return this.http.post(loginUrl, user).pipe(
      tap((response: any) => {
        if (response && response.token) {
          this.token = response.token;
          this.logstatus.emit('authenticated');
          return true;
        } else {
          return false;
        }
      }),
      catchError(this.handleError)
    );
  }

  getToken(): any {
    return this.token;
  }

  logout(): void {
    this.token = null;
    this.logstatus.emit('logged out');
  }

  private handleError(error: HttpErrorResponse) {
    // Handle the error appropriately
    return throwError(error);
  }

  constructor(private http: HttpClient) {}
}
