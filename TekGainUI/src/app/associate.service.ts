import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AssociateService {
  host: string = '';
  token: any = '';
  returnMsg: any = '';

  constructor(private http: HttpClient, private authService: AuthService) { }

  addAssociate(associate: Object): Observable<Object> {
    const headers = new HttpHeaders().set('Authorization', this.token);

    return this.http.post(this.host + '/api/associates', associate, { headers }).pipe(
      catchError(this.handleError)
    );
  }

  updateAssociate(associateId: string, emailId: string): Observable<Object> {
    const headers = new HttpHeaders().set('Authorization', this.token);

    return this.http.put(this.host + `/api/associates/${associateId}`, { emailId }, { headers }).pipe(
      catchError(this.handleError)
    );
  }

  viewAssociates(): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', this.token);

    return this.http.get(this.host + '/api/associates', { headers }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    // Handle the error appropriately
    return throwError(error);
  }
}
