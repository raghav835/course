import { Component, OnInit, Input,  } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { AdmissionService } from '../admission.service';
import { Admission } from '../admission';

@Component({
  selector: 'app-admission',
  templateUrl: './admission.component.html',
  styleUrls: ['./admission.component.css']
})
export class AdmissionComponent implements OnInit {

   registrationId:string='';	
   courseId	:string='';
   associateId:string=''	;
   fees:number=0;	
   feedback	:string='';
   returnfees:any='';
   message:string=''; 
   error:string=''; 
   rating:number=0;
   returnCourseId:any='';
  @Input() admission:any=new Admission('','','',0,'',0); 
  admissionModel:any=new Admission('','','',0,'',0); 
   
 
    admissions: Array<any>=[];
    feedbackArray:Array<Admission> = []; 
    AdmissionsArray= []; 
    paramFlag=1;
    sub:any="";

  @Input()title:string='';

 ngOnInit() {

   
}

ngOnDestroy() {
 //  this.sub.unsubscribe();
  
}

 constructor(private admissionService: AdmissionService,private router: Router,private _Activatedroute:ActivatedRoute) { }
 

 registration() : void {

  if(this.paramFlag==1){
    this.admissionModel=this.admission;
    this.paramFlag=2;
  }
  
  this.admissionService.registration(this.admissionModel).subscribe(
    (registration: Admission) => {
      this.message = 'Registration successful!';
    },
    (    error: string) => {
      this.error = error;
    }
  );
 }

 totalFees(){
 
  this.returnfees=this.admissionService.totalFees(this.fees);
 }

 addFeedback() : void {
 
  this.admissionService.addFeedback(this.feedback,this.registrationId).subscribe(
    (feedback: Admission) => {
      this.message = 'Feedback added successfully!';
    },
    (    error: string) => {
      this.error = error;
    }
  );
 }

 highestFee() : void {  
  
  this.admissionService.highestFee().subscribe(
    (highestFee: Admission) => {
      this.returnfees = highestFee;
    },
    (    error: string) => {
      this.error = error;
    }
  );
 }

 viewFeedbackByCourseId( ){
 
  this.admissionService.viewFeedbackByCourseId(this.courseId).subscribe(
    (feedbackArray: Array<Admission>) => {
      this.feedbackArray = feedbackArray;
    },
    (    error: string) => {
      this.error = error;
    }
  );
 }
   
 makePayment(){

 }
 

}
