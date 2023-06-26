import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CourseService } from '../course.service';
import { Course } from '../course';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  courseId: string = '';
  courseName: string = '';
  fees: number = 0;
  rating: number = 0;
  duration: number = 0;
  courseType: string = '';

  message: string = '';
  instructorNames: string = '';
  error: string = '';

  @Input() course: any = new Course('', '', 0, 0, '', 0);
  courseModel: any = new Course('', '', 0, 0, '', 0);

  courses: Array<any> = [];
  courseById: Array<Course> = [];
  ratings: Array<Course> = [];

  flag1 = 0;
  flag2 = 0;
  paramFlag = 1;
  sub: any = '';

  @Input() title: string = '';

  ngOnInit() {
    this.sub = this._Activatedroute.paramMap.subscribe((params) => {
      this.courseId = params.get('id');
    });

    if (this.courseId) {
      this.viewCourseById();
      this.viewRatings();
    }
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  constructor(
    private courseService: CourseService,
    private router: Router,
    private _Activatedroute: ActivatedRoute
  ) {}

  addCourse(): void {
    this.courseService.addCourse(this.courseModel).subscribe(
      () => {
        this.message = 'Course added successfully!';
        this.courseModel = new Course('', '', 0, 0, '', 0);
      },
      () => {
        this.error = 'Failed to add course.';
      }
    );
  }

  updateCourse(): void {
    this.courseService.updateCourse(this.courseId, this.courseModel).subscribe(
      () => {
        this.message = 'Course updated successfully!';
        this.courseModel = new Course('', '', 0, 0, '', 0);
      },
      () => {
        this.error = 'Failed to update course.';
      }
    );
  }

  viewCourseById(): void {
    this.courseService.getCourseById(this.courseId).subscribe(
      (data: Course[]) => {
        this.courseById = data;
        this.courseModel = Object.assign({}, this.courseById[0]);
      },
      () => {
        this.error = 'Failed to fetch course details.';
      }
    );
  }

  viewRatings() {
    this.courseService.getCourseRatings(this.courseId).subscribe(
      (data: Course[]) => {
        this.ratings = data;
      },
      () => {
        this.error = 'Failed to fetch course ratings.';
      }
    );
  }

  disableCourse(): void {
    this.courseService.disableCourse(this.courseId).subscribe(
      () => {
        this.message = 'Course disabled successfully!';
      },
      () => {
        this.error = 'Failed to disable course.';
      }
    );
  }
}
