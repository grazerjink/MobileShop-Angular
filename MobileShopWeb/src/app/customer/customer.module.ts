import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerComponent } from './customer.component';
import { CustomerRoutingModule } from './customer-routing.module';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { CategoryComponent } from './shared/category/category.component';
import { BestSellerComponent } from './shared/best-seller/best-seller.component';
import { LastestComponent } from './shared/lastest/lastest.component';

@NgModule({
  imports: [
    CommonModule,
    CustomerRoutingModule
  ],
  declarations: [
    CustomerComponent, 
    HeaderComponent, 
    FooterComponent,
    CategoryComponent,
    BestSellerComponent,
    LastestComponent
  ],
  bootstrap: [CustomerComponent]
})
export class CustomerModule { }
