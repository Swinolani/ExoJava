import { AfterViewInit, Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { LoginService } from '../service/login.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [RouterLink],
  providers:[HttpClient],
  template: `
    <h1>Connectez vous ou inscrivez vous pour créer vos todos !</h1>
    <a [routerLink]="['/login']">Login</a><br>
    <a [routerLink]="['/register']">Register</a>

    @if (message!="") { <!-- faut aussi que le token n'existe pas dans la condition !! -->
      <p>Inscription réussi, vous pouvez vous connectez pour profiter de nos services</p>
    }
  `,
  styles: ``
})
export class AccueilComponent implements OnInit{
   message: string="";
  
  constructor(private loginService:LoginService ){
  }
  
  ngOnInit(): void {
    this.loginService.messageSubject.asObservable().subscribe(message =>{this.message=message})
    
    
    
   
  }
  
}
