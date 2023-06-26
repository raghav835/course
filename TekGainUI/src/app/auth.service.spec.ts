import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { AuthService } from './auth.service';

describe('AuthService', () => {
  let service: AuthService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AuthService]
    });
    service = TestBed.inject(AuthService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should log in successfully', () => {
    const user = { username: 'testuser', password: 'testpassword' };
    const response = { token: 'abcd1234' };

    service.login(user).subscribe((result) => {
      expect(result).toBeTrue();
      expect(service.getToken()).toBe(response.token);
    });

    const req = httpMock.expectOne(/* Fill in the login URL */);
    expect(req.request.method).toBe('POST');
    req.flush(response);
  });

  it('should handle login failure', () => {
    const user = { username: 'testuser', password: 'testpassword' };
    const response = { error: 'Invalid credentials' };

    service.login(user).subscribe((result) => {
      expect(result).toBeFalse();
      expect(service.getToken()).toBeFalsy();
    });

    const req = httpMock.expectOne(/* Fill in the login URL */);
    expect(req.request.method).toBe('POST');
    req.flush(response, { status: 401, statusText: 'Unauthorized' });
  });

  it('should log out successfully', () => {
    service.logout();

    expect(service.getToken()).toBeFalsy();
  });
});
function expect(service: AuthService) {
  throw new Error('Function not implemented.');
}

function beforeEach(arg0: () => void) {
  throw new Error('Function not implemented.');
}

function afterEach(arg0: () => void) {
  throw new Error('Function not implemented.');
}

