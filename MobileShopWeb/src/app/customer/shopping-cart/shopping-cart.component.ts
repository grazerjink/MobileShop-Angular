import { Component, OnInit, Input } from '@angular/core';
import { CartInfo } from '../../models/cart-info.model';
import { ShoppingCartService } from '../../services/shopping-cart.service';
import { SanPham } from '../../models/san-pham.model';
import { UserInfo } from '../../models/user-info.model';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  userInfo: UserInfo = {
    diaChi: "",
    ghiChu: "",
    soDienThoai: "",
    tenKhachHang: ""
  }
  cartInfo: CartInfo

  constructor(private shoppingCartService: ShoppingCartService) { }

  ngOnInit() {
    this.getCartInfo()
    this.shoppingCartService.cartInfo.subscribe(
      data => this.cartInfo = data
    );
  }

  getCartInfo() {
    this.cartInfo = this.shoppingCartService.getCartInfo();
  }

  decreaseQuantity(sp: SanPham) {
    if(sp.soLuong > 1) {
      let soLuong = sp.soLuong - 1;
      this.shoppingCartService.capNhatSoLuongSanPham(sp.id, soLuong)
    }
  }

  increaseQuantity(sp: SanPham) {
    let soLuong = sp.soLuong + 1;
    this.shoppingCartService.capNhatSoLuongSanPham(sp.id, soLuong)
  }

  xoaGioHang() {
    this.shoppingCartService.xoaGioHang();
  }

  thanhToanHoaDon() {
    this.shoppingCartService.thanhToanHoaDon(this.userInfo).subscribe(
      idHD => {
        this.shoppingCartService.taoChiTietHoaDon(idHD).subscribe(
            data => {
              this.shoppingCartService.xoaGioHang();
              this.userInfo = {
                diaChi: "",
                ghiChu: "",
                soDienThoai: "",
                tenKhachHang: ""
              }
            }
        );   
      }
    );
  }

}
