import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { async, ComponentFixture, TestBed, inject, tick, fakeAsync } from '@angular/core/testing';
import { Router, ActivatedRoute } from "@angular/router";
import { CourseComponent } from './course/course.component';
import { AdmissionComponent } from './admission/admission.component';
import { AssociateComponent } from './associate/associate.component';
import { AuthService } from './auth.service';
import { HttpClient, HttpClientModule, HttpHandler, HttpResponse } from '@angular/common/http';
import { Location } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

describe('AppComponent', () => {
  let fixture: ComponentFixture<AppComponent>;
  let app: AppComponent;
  let location: Location;
  let router: Router;
  let httpMock: HttpTestingController;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        FormsModule,
        ReactiveFormsModule,
        HttpClientTestingModule,
        RouterTestingModule.withRoutes([]),
      ],
      declarations: [
        AppComponent,
        CourseComponent,
        AdmissionComponent,
        AssociateComponent
      ],
      providers: [
        AuthService
      ]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent);
    app = fixture.componentInstance;
    router = TestBed.inject(Router);
    location = TestBed.inject(Location);
    httpMock = TestBed.inject(HttpTestingController);
    fixture.detectChanges();
  });

  it('should create the app', () => {
    expect(app).toBeTruthy();
  });

  it('should have the router for Course menu', fakeAsync(() => {
    router.navigate(['/courses']);
    tick();
    expect(location.path()).toBe('/courses');
  }));

  it('should have the router for Associate menu', fakeAsync(() => {
    router.navigate(['/associates']);
    tick();
    expect(location.path()).toBe('/associates');
  }));

  it('should have the router for Admission menu', fakeAsync(() => {
    router.navigate(['/admissions']);
    tick();
    expect(location.path()).toBe('/admissions');
  }));

  afterEach(() => {
    httpMock.verify();
  });
});
