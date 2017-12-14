import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTabsModule } from '@angular/material';
import { Ng2CarouselamosModule } from 'ng2-carouselamos';

import { ProductDetailComponent } from './product-detail.component';
import { ProductDetailRoutingModule } from './product-detail-routing.module';

@NgModule({
  imports: [
    CommonModule,
    ProductDetailRoutingModule,
    MatTabsModule,
    Ng2CarouselamosModule
  ],
  declarations: [ProductDetailComponent],
  bootstrap:[ProductDetailComponent]
})
export class ProductDetailModule { }
