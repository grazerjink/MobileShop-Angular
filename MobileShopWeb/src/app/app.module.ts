import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AppRoutingModule } from './/app-routing.module';
import { CategoryComponent } from './category/category.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { TinhTrangService } from './services/tinh-trang.service';
import { ApiService } from './services/api.service';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CategoryComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    ApiService,
    TinhTrangService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
