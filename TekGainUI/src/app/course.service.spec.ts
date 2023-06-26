import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { CourseService } from './course.service';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });
    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should add a course', () => {
    const course = { name: 'Math', instructor: 'John Doe' };
    const expectedResponse = { message: 'Course added successfully' };

    service.addCourse(course).subscribe(response => {
      expect(response).toEqual(expectedResponse);
    });

    const req = httpMock.expectOne('/api/courses');
    expect(req.request.method).toBe('POST');
    req.flush(expectedResponse);
  });

  it('should update a course', () => {
    const courseId = '123';
    const fees = 200;
    const expectedResponse = { message: 'Course updated successfully' };

    service.updateCourse(courseId, fees).subscribe(response => {
      expect(response).toEqual(expectedResponse);
    });

    const req = httpMock.expectOne(`/api/courses/${courseId}`);
    expect(req.request.method).toBe('PUT');
    req.flush(expectedResponse);
  });

  it('should retrieve all courses', () => {
    const expectedCourses = [{ name: 'Math', instructor: 'John Doe' }];

    service.viewAllCourses().subscribe(courses => {
      expect(courses).toEqual(expectedCourses);
    });

    const req = httpMock.expectOne('/api/courses');
    expect(req.request.method).toBe('GET');
    req.flush(expectedCourses);
  });

  it('should disable a course', () => {
    const courseId = '123';
    const expectedResponse = { message: 'Course disabled successfully' };

    service.disableCourse(courseId).subscribe(response => {
      expect(response).toEqual(expectedResponse);
    });

    const req = httpMock.expectOne(`/api/courses/${courseId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush(expectedResponse);
  });
});
function expect(method: any) {
    throw new Error('Function not implemented.');
}

function afterEach(arg0: () => void) {
    throw new Error('Function not implemented.');
}

function beforeEach(arg0: () => void) {
    throw new Error('Function not implemented.');
}

