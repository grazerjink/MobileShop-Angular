import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ApiService } from './services/api.service';
import { HangSanXuatService } from './services/hang-san-xuat.service';
import { SanPhamService } from './services/san-pham.service';
import { TinhTrangService } from './services/tinh-trang.service';
import { HttpClientModule } from '@angular/common/http'; 
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ShoppingCartService } from './services/shopping-cart.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HttpModule,
    BrowserAnimationsModule,
    NgbModule
  ],
  providers: [
    ApiService,
    HangSanXuatService,
    SanPhamService,
    TinhTrangService,
    ShoppingCartService
  ],
  bootstrap:[AppComponent]
})
export class AppModule { }
