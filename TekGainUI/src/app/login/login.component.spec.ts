import { RouterTestingModule, } from '@angular/router/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { AppComponent } from '../app.component';
import { NgModule } from '@angular/core';
import { async, ComponentFixture, TestBed,inject,tick,fakeAsync, getTestBed } from '@angular/core/testing';
import {Router,ActivatedRoute} from "@angular/router";

import { AuthService } from '../auth.service';
import { LoginComponent } from './login.component';
import { HttpClient,HttpClientModule, HttpHandler ,HttpResponse } from '@angular/common/http';
import { Component, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { AppModule,routes } from '../app.module';
import {Location} from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule,ReactiveFormsModule }   from '@angular/forms';
import { User } from '../user';

describe('LoginComponent', () => {

  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let httpMock: HttpTestingController;
  let authService: AuthService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientTestingModule,
        AppModule,
        FormsModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
      ],
      declarations: [LoginComponent],
      providers: [
        AuthService,
        {
          provide: HttpClient,
          useFactory: () => {
            return httpMock;
          },
        },
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    httpMock = TestBed.get(HttpTestingController);
    authService = fixture.debugElement.injector.get(AuthService);
  }));

  it('should login successfully', async(async () => {
    const user = new User('test@email.com', 'password');
    httpMock.expectOne('api/auth/login').andReturn(
      new HttpResponse({
        status: 200,
        body: user,
      })
    );

    component.email = user.email;
    component.password = user.password;
    fixture.detectChanges();

    await fixture.flush();

    expect(authService.isLoggedIn).toBe(true);
  }));

  it('should not login if email or password is invalid', async(async () => {
    httpMock.expectOne('api/auth/login').andReturn(
      new HttpResponse({
        status: 401,
        body: {
          error: 'Invalid email or password',
        },
      })
    );

    component.email = 'invalid@email.com';
    component.password = 'invalid';
    fixture.detectChanges();

    await fixture.flush();

    expect(authService.isLoggedIn).toBe(false);
  }));
});
function beforeEach(arg0: any) {
    throw new Error('Function not implemented.');
}

function expect(isLoggedIn: any) {
    throw new Error('Function not implemented.');
}

