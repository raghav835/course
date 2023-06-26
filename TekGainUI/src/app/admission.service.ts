import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdmissionService {
  returnMsg: any = '';

  constructor(private http: HttpClient, private authService: AuthService) { }

  registration(associateId: string, courseId: string): Observable<Object> {
    const url = ''; // Add your registration API endpoint URL here
    const body = {
      associateId: associateId,
      courseId: courseId
    };
    const headers = new HttpHeaders().set('Authorization', this.authService.getToken());
    return this.http.post(url, body, { headers: headers }).pipe(
      catchError(this.handleError)
    );
  }

  calculateFees(associateId: string): Observable<any> {
    const url = ''; // Add your calculate fees API endpoint URL here
    const params = { associateId: associateId };
    const headers = new HttpHeaders().set('Authorization', this.authService.getToken());
    return this.http.get(url, { params: params, headers: headers }).pipe(
      catchError(this.handleError)
    );
  }

  addFeedback(regNo: string, feedback: string, feedbackRating: number): Observable<any> {
    const url = ''; // Add your add feedback API endpoint URL here
    const body = {
      regNo: regNo,
      feedback: feedback,
      feedbackRating: feedbackRating
    };
    const headers = new HttpHeaders().set('Authorization', this.authService.getToken());
    return this.http.post(url, body, { headers: headers }).pipe(
      catchError(this.handleError)
    );
  }

  highestFeeForTheRegisteredCourse(associateId: string): Observable<any> {
    const url = ''; // Add your highest fee API endpoint URL here
    const params = { associateId: associateId };
    const headers = new HttpHeaders().set('Authorization', this.authService.getToken());
    return this.http.get(url, { params: params, headers: headers }).pipe(
      catchError(this.handleError)
    );
  }

  viewFeedbackByCourseId(courseId: string): Observable<any> {
    const url = ''; // Add your view feedback API endpoint URL here
    const params = { courseId: courseId };
    const headers = new HttpHeaders().set('Authorization', this.authService.getToken());
    return this.http.get(url, { params: params, headers: headers }).pipe(
      catchError(this.handleError)
    );
  }

  viewAllAdmissions(): Observable<any> {
    const url = ''; // Add your view all admissions API endpoint URL here
    const headers = new HttpHeaders().set('Authorization', this.authService.getToken());
    return this.http.get(url, { headers: headers }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'An error occurred';
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      errorMessage = error.error.message;
    } else {
      // Server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
  }
}
