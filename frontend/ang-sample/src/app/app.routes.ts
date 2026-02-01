import { Routes } from '@angular/router';
import { UserProfile } from './components/userProfile';

export const routes: Routes = [
  {
    path: '',
    title: 'App Home Page',
    component: UserProfile,
  },
];
