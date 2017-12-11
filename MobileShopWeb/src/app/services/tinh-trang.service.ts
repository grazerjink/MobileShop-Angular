import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { TinhTrang } from '../models/tinh-trang.model'
import { ApiService } from './api.service'
import { log } from 'util';
import { errorHandler } from '@angular/platform-browser/src/browser';
import { HttpParams } from '@angular/common/http/src/params';

@Injectable()
export class TinhTrangService {

  constructor(private http: HttpClient, private api: ApiService) { }

  getTinhTrangs(): Observable<TinhTrang[]> {
    return this.http.get<TinhTrang[]>(this.api.getApiUrl("api/ds-tinhtrang")).pipe(
        catchError(this.api.handleError('getTinhTrangs', []))
    );
  }

  addTinhTrang(moTa: string):Observable<TinhTrang> {
    return this.http.post<TinhTrang>(this.api.getApiUrl("api/them-tinhtrang"),moTa)
    .pipe(
      catchError(this.api.handleError<TinhTrang>('addTinhTrang', null))
    );
  }

  editTinhTrang(tinhtrang: TinhTrang):Observable<TinhTrang> {
    return this.http.put<TinhTrang>(this.api.getApiUrl("api/sua-tinhtrang"),tinhtrang)
    .pipe(
      catchError(this.api.handleError<TinhTrang>('editTinhTrang', null))
    );
  }

  removeTinhTrang(id: number):Observable<string> {
    return this.http.delete<string>(this.api.getApiUrl(`api/xoa-tinhtrang/${id}`))
    .pipe(
      catchError(this.api.handleError<string>('removeTinhTrang', "Request Error"))
    );
  }

}

