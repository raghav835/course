import { async, ComponentFixture, TestBed, fakeAsync } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { CourseComponent } from './course.component';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { of } from 'rxjs';
import { CourseService } from '../course.service';
import { Course } from '../course';

describe('CourseComponent', () => {
  let component: CourseComponent;
  let fixture: ComponentFixture<CourseComponent>;
  let httpMock: HttpTestingController;
  let courseService: CourseService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CourseComponent],
      imports: [FormsModule, RouterTestingModule, HttpClientTestingModule],
      providers: [CourseService]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseComponent);
    component = fixture.componentInstance;
    httpMock = TestBed.inject(HttpTestingController);
    courseService = TestBed.inject(CourseService);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should create the component', () => {
    return expect(component).toBeTruthy();
  });

  it('should get course by ID', fakeAsync(() => {
    const mockCourse: Course = { id: 1, name: 'Angular', duration: '2 months', fee: 1000 };
    const courseId = 1;

    spyOn(courseService, 'getCourseById').and.returnValue(of(mockCourse));

    component.viewCourseById(courseId);

    expect(component.course).toEqual(mockCourse);
    expect(courseService.getCourseById).toHaveBeenCalledWith(courseId);
  }));

  it('should get course ratings', fakeAsync(() => {
    const mockRatings = [4, 5, 3, 4, 5];
    const courseId = 1;

    spyOn(courseService, 'getCourseRatings').and.returnValue(of(mockRatings));

    component.viewRatings(courseId);

    expect(component.ratings).toEqual(mockRatings);
    expect(courseService.getCourseRatings).toHaveBeenCalledWith(courseId);
  }));
});
function expect(ratings: Course[]) {
  throw new Error('Function not implemented.');
}

function spyOn(courseService: CourseService, arg1: string) {
  throw new Error('Function not implemented.');
}

function beforeEach(arg0: () => void) {
  throw new Error('Function not implemented.');
}

