import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

import { errorHandler } from '@angular/platform-browser/src/browser';
import { HttpParams } from '@angular/common/http/src/params';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators';
import { Subject } from "rxjs/Subject";

import { ApiService } from './api.service';
import { CartInfo } from "../models/cart-info.model";
import { SanPham } from "../models/san-pham.model";
import { UserInfo } from "../models/user-info.model";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};

@Injectable()
export class ShoppingCartService {

  private cartSubject = new Subject<CartInfo>();

  cartInfo = this.cartSubject.asObservable();

  gioHangMap: Map<number, SanPham>;

  constructor(private http: HttpClient, private api: ApiService) { 
    if(this.layGioHangTrongSession() == null) {
      sessionStorage.setItem("gioHang", JSON.stringify(new Map<number, SanPham>()));
    }
    this.gioHangMap = JSON.parse(sessionStorage.getItem("gioHang"));
  }

  layGioHangTrongSession(): Map<number, SanPham> {
    return JSON.parse(sessionStorage.getItem("gioHang"));
  }

  capNhatSessionStorage():void {
    sessionStorage.removeItem("gioHang");
    sessionStorage.setItem("gioHang", JSON.stringify(this.gioHangMap));
    this.cartSubject.next(this.getCartInfo());
  }

	themSanPhamVaoGioHang(id: number) {
    let sanPham = this.laySanPhamTheoId(id);
		if(sanPham != null) {
      sanPham.soLuong = sanPham.soLuong + 1;
      this.capNhatSessionStorage();   
		}
		else {
      this.http.get<SanPham>(this.api.getApiUrl(`api/sanpham/${id}`)).subscribe(
        data => {
          sanPham = data;
          sanPham.soLuong = 1;
          this.gioHangMap[id] = sanPham
          this.capNhatSessionStorage();   
        }
      );	
    }     
  }

  themSanPhamVaSoLuong(sp: SanPham, soLuong:number) {
    let sanPham = this.laySanPhamTheoId(sp.id);
		if(sanPham != null) {
      sanPham.soLuong = sanPham.soLuong + soLuong;
      this.capNhatSessionStorage();   
		}
		else {
      this.http.get<SanPham>(this.api.getApiUrl(`api/sanpham/${sp.id}`)).subscribe(
        data => {
          sanPham = data;
          sanPham.soLuong = soLuong;
          this.gioHangMap[sp.id] = sanPham
          this.capNhatSessionStorage();   
        }
      );
    }  
  }
  
	xoaSanPhamTrongGioHang(id: number): void {
    delete this.gioHangMap[id];
    this.capNhatSessionStorage();
  }
  
	xoaGioHang(): void {      
    sessionStorage.removeItem("gioHang");
    sessionStorage.setItem("gioHang", "{}");  
    this.gioHangMap = JSON.parse(sessionStorage.getItem("gioHang"));
    this.cartSubject.next(this.getCartInfo());
  }
  
	capNhatSoLuongSanPham(id: number, newQuantity: number): void {
		let sanPham = this.laySanPhamTheoId(id);
    sanPham.soLuong = newQuantity;
    this.capNhatSessionStorage();
  }
  
	layTongSoLuongSanPham() : number {
    let total = 0;
    Object.keys(this.gioHangMap).forEach((key) => {
      total += this.gioHangMap[key].soLuong
    });
		return total;
  }
  
	layTongTien(): number {
    let total = 0.00;
    Object.keys(this.gioHangMap).forEach((key) => {
      total += this.gioHangMap[key].giaBan * this.gioHangMap[key].soLuong
    });
		return total;
  }
  
  layDanhSachSanPham() : SanPham[] {
    let sanPhams = [];
    Object.keys(this.gioHangMap).forEach((key) => {
        sanPhams.push(this.gioHangMap[key])
    });
    return sanPhams;
  }
	
	laySanPhamTheoId(id: number) : SanPham {
    let sanPham = null;
		Object.keys(this.gioHangMap).filter((key) => {
      if(key === id.toString()) {
        sanPham = this.gioHangMap[key]
      }
    });
    return sanPham;
  } 

  getCartInfo(): CartInfo {
    let cartInfo = {
      idHoaDon: 0,
      tongSoLuong: this.layTongSoLuongSanPham(),
      tongTien: this.layTongTien(),
      sanPhams: this.layDanhSachSanPham() 
    }
    return cartInfo;
  }   

  thanhToanHoaDon(userInfo: UserInfo): Observable<number>{
    return this.http.post<number>(this.api.getApiUrl("api/taohoadon/"),userInfo);
  }

  taoChiTietHoaDon(idHD: number): Observable<number> {
    let cart = this.getCartInfo();
    cart.idHoaDon = idHD;
    return this.http.post<number>(this.api.getApiUrl("api/taochitiethoadon"),cart);
  }
  
}