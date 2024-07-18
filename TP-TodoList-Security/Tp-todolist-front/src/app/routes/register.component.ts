import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { LoginService } from '../service/login.service';
import { ActivatedRoute, Router, Routes } from '@angular/router';
import { HttpClient, HttpHandler } from '@angular/common/http';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  providers:[HttpClient],
  template: `
     <h2>Register</h2>
    <form (ngSubmit)="onSubmit(registerForm)" #registerForm="ngForm">
      <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" ngModel required>
      </div>
      <div>
        <label for="mail">Email:</label>
        <input type="email" id="mail" name="mail" ngModel required>
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" ngModel required>
      </div>
      <div>
        <label for="role">Role:</label>
        <select id="role" name="role" ngModel required>
          <option value="USER">USER</option>
          <option value="ADMIN">ADMIN</option>
        </select>
      </div>
      <button type="submit" [disabled]="!registerForm.form.valid">Register</button>
    </form>
    <strong style="color:red">{{erreur}}</strong>
  `,
  styles: ` div {
      margin-bottom: 10px;
    }
    label {
      display: inline-block;
      width: 100px;
    }
    input, select {
      width: 200px;
    }`
})
export class RegisterComponent {
  erreur:string=""
  constructor(private loginService:LoginService,private router:Router) { }  

  onSubmit(form: NgForm): void {
    if (form.valid) {
      
      this.loginService.register(form.value).subscribe({
        next: (response) => {
          this.loginService.messageSubject.next(response.message);
          this.router.navigate(['/']);
        },
        error: (error) => {
          this.erreur=`L'utilisateur est déjà inscrit, erreur ${error.status}`
          console.log(error);
          
        }
      });
    }
    
  }

}
