import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ShoppingCartComponent } from './shopping-cart.component';
import { ShoppingCartRoutingModule } from './shopping-cart-routing.module';

@NgModule({
  imports: [
    CommonModule,
    ShoppingCartRoutingModule,
    FormsModule
  ],
  declarations: [ShoppingCartComponent],
  bootstrap:[ShoppingCartComponent]
})
export class ShoppingCartModule { }
