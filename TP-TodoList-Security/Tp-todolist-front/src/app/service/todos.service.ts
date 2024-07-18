import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Todo } from '../interface/todo';

@Injectable({
  providedIn: 'root'
})
export class TodosService {
  private baseUrl = 'http://localhost:8080/todos';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token')?.toString()
  
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ` + token
    });
  }

  createTodo(todo: Todo): Observable<Todo> {
    const headers = this.getAuthHeaders();
    return this.http.post<Todo>(`${this.baseUrl}/createTodo`, todo, { headers });
  }

  getAllTodos(): Observable<Todo[]> {
    const headers = this.getAuthHeaders();
    return this.http.get<Todo[]>(`${this.baseUrl}/listTodos`, { headers });
  }
}
