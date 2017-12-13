import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators';

import { SanPham } from '../models/san-pham.model';
import { ApiService } from './api.service';

@Injectable()
export class SanPhamService {

  constructor(private http: HttpClient, private api: ApiService) { }

  getSanPhams(): Observable<SanPham[]> {
    return this.http.get<SanPham[]>(this.api.getApiUrl("api/sanphams")).pipe(
        catchError(this.api.handleError('getSanPhams', []))
    );
  }

  getSanPhamsByCategoryId(categoryId: number): Observable<SanPham[]> {
    return this.http.get<SanPham[]>(this.api.getApiUrl(`api/sanphams/${categoryId}`)).pipe(
        catchError(this.api.handleError('getSanPhams', []))
    );
  }

}
