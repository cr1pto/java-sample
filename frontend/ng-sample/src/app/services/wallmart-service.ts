import { HttpClient, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { AssociateItem } from '../models/associate-item';
import { map, Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class WallmartService {
  private apiUrl = 'http://localhost:8080';
  private http = inject(HttpClient);
  getAssociates(): Observable<AssociateItem[]> {
    // const params = new HttpParams({
    //   encoder: new CustomHttpParamEncoder(),
    // })
    //   .set('email', 'dev+alerts@example.com')
    //   .set('q', 'a & b? c/d = e');
    // return this.http.get('/api/items', { params });
    return this.http.get<AssociateItem[]>(`${this.apiUrl}/associates`).pipe(
      map(
        (res) => {
          // console.log(res);
          return res;
        },
        // res => {
        //   return {
        //     firstName: res.firstName,
        //     lastName: res.lastName
        //   }
        // }
      ),
    );
  }
}
