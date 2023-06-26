import { TestBed } from '@angular/core/testing';

import { AdmissionService } from './admission.service';

describe('AdmissionService', () => {
  let service: AdmissionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdmissionService);
  });

  it('should get the list of admissions', async(() => {
    const admissions = [
      {
        id: 1,
        name: 'John Doe',
        email: 'johndoe@example.com',
        status: 'Pending',
      },
      {
        id: 2,
        name: 'Jane Doe',
        email: 'janedoe@example.com',
        status: 'Admitted',
      },
    ];

    service.getAdmissionList().subscribe(function (result: any): void {
      expect(result).toEqual(admissions);
    });
  }));

  it('should get an admission by id', async(() => {
    const admission = {
      id: 1,
      name: 'John Doe',
      email: 'johndoe@example.com',
      status: 'Pending',
    };

    service.getAdmissionList(1).subscribe(function (result: any): void {
      expect(result).toEqual(admission);
    });
  });
});
function expect(result: any) {
  throw new Error('Function not implemented.');
}

function async(arg0: () => void): any {
  throw new Error('Function not implemented.');
}

function beforeEach(arg0: () => void) {
  throw new Error('Function not implemented.');
}

