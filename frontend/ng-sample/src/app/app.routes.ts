import { Routes } from '@angular/router';
import { Associates } from './associates/associates';
import { Home } from './home/home';

export const routes: Routes = [
  {
    path: '',
    title: 'Home',
    component: Home,
  },
  {
    path: 'associates',
    title: 'Associates',
    component: Associates,
  },
];
