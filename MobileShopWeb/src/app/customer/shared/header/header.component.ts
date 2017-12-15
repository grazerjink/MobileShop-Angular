import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from '../../../services/shopping-cart.service';
import { CartInfo } from '../../../models/cart-info.model';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  private subscription : Subscription;
  cartInfo: CartInfo;

  constructor(
    private shoppingCartService: ShoppingCartService) {
  }

  ngOnInit() {
    this.getCartInfo();
    this.subscription = this.shoppingCartService.cartInfo
    .subscribe((sub) => {
        this.cartInfo = sub
    });
  }

  getCartInfo() {
    this.cartInfo = this.shoppingCartService.getCartInfo();
  }

  xoaSanPham(id: number) {
    this.shoppingCartService.xoaSanPhamTrongGioHang(id);
    this.cartInfo = this.shoppingCartService.getCartInfo();
  }

}
