import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  messageSubject: BehaviorSubject<string> = new BehaviorSubject<string>("");
  private registerUrl = 'http://localhost:8080/register';  
  private loginUrl = 'http://localhost:8080/login';

  constructor(private http: HttpClient) { }


  register(user: any): Observable<any> {
    return this.http.post(this.registerUrl, user);
  }
  login(user:any) : Observable<any>{
    return this.http.post(this.loginUrl,user)
  }
}
