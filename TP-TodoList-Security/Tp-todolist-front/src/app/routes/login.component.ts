import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  template: `
     <h2>Login</h2>
    <form (ngSubmit)="onSubmit(loginForm)" #loginForm="ngForm">
      <div>
        <label for="mail">Email:</label>
        <input type="email" id="mail" name="mail" ngModel required>
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" ngModel required>
      </div>
      <button type="submit" [disabled]="!loginForm.form.valid">Login</button>
    </form>

    <strong style="color:red">{{erreur}}</strong>
  `,
  styles: `
   div {
      margin-bottom: 10px;
    }
    label {
      display: inline-block;
      width: 100px;
    }
    input {
      width: 200px;
    }`
})
export class LoginComponent {
  erreur:string=""
  constructor(private loginService:LoginService ,private router:Router){
  }
  onSubmit(form:NgForm):void {
    if (form.valid) {
      
      this.loginService.login(form.value).subscribe({
        next: (response) => {
          localStorage.setItem("token",response.data.token)
          this.router.navigate(['/todos'])
          
        },
        error: (error) => {
          console.error('Registration failed', error);
        }
      });
    }
    
  }
    
  
}


