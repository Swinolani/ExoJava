import { Routes } from '@angular/router';
import { AccueilComponent } from './routes/accueil.component';
import { LoginComponent } from './routes/login.component';
import { RegisterComponent } from './routes/register.component';
import { ErrorComponent } from './routes/error.component';
import { TodosComponent } from './routes/todos.component';

export const routes: Routes = [
    {path:"accueil",component:AccueilComponent},
    {path:"login",component:LoginComponent},
    {path:"register",component:RegisterComponent},
    {path:"todos",component:TodosComponent},
    {path:"",redirectTo:"accueil",pathMatch:"full"},
    {path:"**",component:ErrorComponent}
];
