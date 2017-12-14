import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

import { errorHandler } from '@angular/platform-browser/src/browser';
import { HttpParams } from '@angular/common/http/src/params';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators';

import { ApiService } from './api.service';
import { SanPham } from "../models/san-pham.model";

@Injectable()
export class ShoppingCartService {

    constructor(private http: HttpClient, private api: ApiService) { }

    getCartInfo(): Observable<SanPham[]> {
        return this.http.get<SanPham[]>(this.api.getApiUrl(`api/cartinfo`)).pipe(
          catchError(this.api.handleError('getCartInfo', null))
        );
      }
}