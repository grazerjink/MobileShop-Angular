import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators';

import { ApiService } from './api.service';
import { SanPham } from '../models/san-pham.model';

@Injectable()
export class SanPhamService {

  constructor(private http: HttpClient, private api: ApiService) { }

  getSanPhams(hangId: string = ""): Observable<SanPham[]> {
    if(hangId === "" || hangId === null) {
      return this.http.get<SanPham[]>(this.api.getApiUrl("api/sanphams")).pipe(
          catchError(this.api.handleError('getSanPhams', []))
      );
    }
    else {
      return this.http.get<SanPham[]>(this.api.getApiUrl(`api/sanphams/${hangId}`)).pipe(
        catchError(this.api.handleError('getSanPhams', []))
      );
    }
  }

  getSanPhamById(id: string): Observable<SanPham> {
    return this.http.get<SanPham>(this.api.getApiUrl(`api/sanpham/${id}`)).pipe(
      catchError(this.api.handleError('getSanPhamById', null))
    );
  }

  searchSanPhamByName(name: string): Observable<SanPham[]> {
    return this.http.get<SanPham[]>(this.api.getApiUrl(`api/timkiem/?name=${name}`)).pipe(
      catchError(this.api.handleError('searchSanPhamByName', null))
    );
  }

  getSanPhamRelateds(sanPhamId: string): Observable<SanPham[]> {
    return this.http.get<SanPham[]>(this.api.getApiUrl(`api/sanphamrelateds/${sanPhamId}`)).pipe(
        catchError(this.api.handleError('getSanPhamRelateds', []))
    );
  }

  getSanPhamBanChays(): Observable<SanPham[]> {
    return this.http.get<SanPham[]>(this.api.getApiUrl(`api/sanphambanchays/`)).pipe(
      catchError(this.api.handleError('getSanPhamBanChays', []))
    );
  }

  getSanPhamMois(): Observable<SanPham[]> {
    return this.http.get<SanPham[]>(this.api.getApiUrl(`api/sanphammois/`)).pipe(
      catchError(this.api.handleError('getSanPhamMois', []))
    );
  }
}
