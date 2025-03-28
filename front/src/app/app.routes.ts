import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: 'home',
        loadComponent: () => import('./pages/home/home.component').then(c => c.HomeComponent)
    },
    {
        path: 'topics',
        loadComponent: () => import('./pages/topics/topics.component').then(c => c.TopicsComponent)
    },
    {
        path: 'register',
        loadComponent: () => import('./pages/registration-form/registration-form.component').then(c => c.RegistrationFormComponent)
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    },

];