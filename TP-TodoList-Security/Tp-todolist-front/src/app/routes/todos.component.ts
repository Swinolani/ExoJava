import { Component } from '@angular/core';
import { TodosService } from '../service/todos.service';
import { FormsModule, NgForm } from '@angular/forms';
import { Todo } from '../interface/todo';

@Component({
  selector: 'app-todos',
  standalone: true,
  imports: [FormsModule],
  template: `
    <h2>Create Todo</h2>
<form (ngSubmit)="onSubmit(todoForm)" #todoForm="ngForm">
  <div>
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" ngModel required>
  </div>
  <div>
    <label for="description">Description:</label>
    <textarea id="description" name="description" ngModel></textarea>
  </div>
  <button type="submit" [disabled]="!todoForm.form.valid">Create Todo</button>
</form>
<hr>
<h2>List Todos</h2>
<ul>
  @for (todo of todos; track $index) {

    <li >
      <strong>Title:</strong> {{ todo.title }} <br>
      <strong>Description:</strong> {{ todo.description }}
    </li>
  }
</ul>

  `,
  styles: ``
})
export class TodosComponent {
  todos: Todo[] = [];

  constructor(private todoService: TodosService) {}

  ngOnInit(): void {
    this.loadTodos();
  }

  loadTodos(): void {
    this.todoService.getAllTodos().subscribe({
      next: (todos) => {
        this.todos = todos;
      },
      error: (error) => {
        console.error('Failed to fetch todos:', error);
      }
    });
  }
  onSubmit(form: NgForm): void {
    if (form.valid) {
      const todo:Todo = {
        title: form.value.title,
        description: form.value.description,
        completed: true,
      };

      this.todoService.createTodo(todo).subscribe({
        next: (createdTodo) => {
          console.log('Todo created successfully:', createdTodo);
          form.resetForm();
        },
        error: (error) => {
          console.error('Failed to create todo:', error);
        }
      });
    }
  }

}
