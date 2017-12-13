import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { MatTabsModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { CategoryComponent } from './category/category.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { TinhTrangService } from './services/tinh-trang.service';
import { ApiService } from './services/api.service';
import { ProductComponent } from './product/product.component';
import { SanPhamService } from './services/san-pham.service';
import { DetailComponent } from './detail/detail.component';
import { HangSanXuatService } from './services/hang-san-xuat.service';

@NgModule({
  declarations: [
    AppComponent,
    CategoryComponent,
    HeaderComponent,
    FooterComponent,
    ProductComponent,
    DetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTabsModule
  ],
  providers: [
    ApiService,
    TinhTrangService,
    SanPhamService,
    HangSanXuatService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
