import { Component, OnInit } from '@angular/core';
import { AdmissionService } from '../admission.service';
import { Course } from '../course';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-admission',
  templateUrl: './admission.component.html',
  styleUrls: ['./admission.component.css']
})
export class AdmissionComponent implements OnInit {

  admissionList: Course[] = [];
  selectedCourse: Course | undefined;
  courseId: string | undefined;

  constructor(
    private admissionService: AdmissionService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.courseId = this.activatedRoute.snapshot.paramMap.get('courseId');
    this.getAdmissionList();
  }

  getAdmissionList() {
    this.admissionService.getAdmissionList(this.courseId).subscribe(
      (admissionList: Course[]) => {
        this.admissionList = admissionList;
      },
      (      error: any) => {
        console.log(error);
      }
    );
  }

  selectCourse(course: Course) {
    this.selectedCourse = course;
  }
}
