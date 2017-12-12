import { Injectable } from '@angular/core';
import { HangSanXuat } from '../models/hang-sx.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators';
import { ApiService } from './api.service';

@Injectable()
export class HangSanXuatService {

  constructor(private http: HttpClient, private api: ApiService) { }

  getHangSanXuats(): Observable<HangSanXuat[]> {
    return this.http.get<HangSanXuat[]>(this.api.getApiUrl("api/hangsanxuats")).pipe(
        catchError(this.api.handleError('getHangSanXuats', []))
    );
  }

}
