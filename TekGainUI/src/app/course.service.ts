import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  getCourseById(getCourseById: any) {
    throw new Error('Method not implemented.');
  }
  getCourseRatings(getCourseRatings: any) {
    throw new Error('Method not implemented.');
  }

  host: string = '';
  token: any = '';
  returnMsg: any = '';

  constructor(private http: HttpClient, private authService: AuthService) { }

  addCourse(course: Object): Observable<Object> {
    const headers = new HttpHeaders().set('Authorization', this.token);

    return this.http.post(this.host + '/api/courses', course, { headers }).pipe(
      catchError(this.handleError)
    );
  }

  updateCourse(courseId: string, fees: number): Observable<Object> {
    const headers = new HttpHeaders().set('Authorization', this.token);

    return this.http.put(this.host + '/api/courses/' + courseId, { fees }, { headers }).pipe(
      catchError(this.handleError)
    );
  }

  viewAllCourses(): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', this.token);

    return this.http.get(this.host + '/api/courses', { headers }).pipe(
      catchError(this.handleError)
    );
  }

  disableCourse(courseId: string): Observable<Object> {
    const headers = new HttpHeaders().set('Authorization', this.token);

    return this.http.delete(this.host + '/api/courses/' + courseId, { headers }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    // Handle the error appropriately
    return throwError(error);
  }
}
