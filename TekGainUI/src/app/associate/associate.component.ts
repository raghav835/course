import { Component, OnInit, Input,  } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { AssociateService } from '../associate.service';
import { Associate } from '../associate';

@Component({
  selector: 'app-associate',
  templateUrl: './associate.component.html',
  styleUrls: ['./associate.component.css']
})
export class AssociateComponent implements OnInit {

  associateId:string='';
  associateName:string='';
  associateAddress:string='';
  associateEmailId:string='';


   message:string=''; 
   error:string='';

 
 @Input() associate:any=new Associate('','','',''); 
 associateModel:any=new Associate('','','',''); 

   
 // instructorNames =[];
 associates: Array<any>=[];
 associatesById: Array<any>=[];
 paramFlag=1;
 sub:any="";

 @Input()title:string='';

 ngOnInit() {

   
  //  fill the code
  
    if(this.paramFlag ==1){
      this.associateModel=this.associate;
      this.paramFlag=2;
    }
    if(this.associateId!=''){
      this.associatesById=this.associateService.getAssociateById(this.associateId);
    }else{
      this.viewAssociates();
    }
  
}


ngOnDestroy() {
 
 //  fill the code
 
}

 constructor(private associateService: AssociateService,private router: Router,private _Activatedroute:ActivatedRoute) { }
 
 
 addAssociate() : void {
 
  this.associateService.addAssociate(this.associateModel).subscribe(
    (associate: Associate) => {
      this.message = 'Associate added successfully!';
      this.associates = this.associateService.getAssociates();
    },
    (    error: string) => {
      this.error = error;
    }
  );
 }


updateCourse() : void {

  this.associateService.updateAssociate(this.associateModel).subscribe(
    (associate: Associate) => {
      this.message = 'Associate updated successfully!';
      this.associates = this.associateService.getAssociates();
    },
    (    error: string): void => {
      this.error = error;
    }
  );
 }

 viewAssociates() : void {  
  
  this.associates = this.associateService.getAssociates();
  
 }

 

 

}

