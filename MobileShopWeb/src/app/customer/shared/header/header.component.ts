import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from '../../../services/shopping-cart.service';
import { CartInfo } from '../../../models/cart-info.model';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { SanPhamService } from '../../../services/san-pham.service';
import { Router } from '@angular/router';
import { Input } from '@angular/core/src/metadata/directives';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  private subscription : Subscription;
  cartInfo: CartInfo;
  timKiem: string = "";

  constructor(
    private router: Router,
    private shoppingCartService: ShoppingCartService) {}

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

  timKiemSanPham() {
    this.router.navigate([`/tim-kiem/${this.timKiem}`]);
  }

}
