import { Component, OnInit, Output } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { log } from 'util';
import { SanPham } from '../../models/san-pham.model';
import { SanPhamService } from '../../services/san-pham.service';
import { ActivatedRoute } from '@angular/router';
import { Params } from '@angular/router/src/shared';
import { ShoppingCartService } from '../../services/shopping-cart.service';

declare const $: any;

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  tieuDe: string = "Tất cả sản phẩm";
  sanPhams: SanPham[];

  constructor(
    private sanPhamService: SanPhamService,
    private shoppingCartService: ShoppingCartService,
    private route: ActivatedRoute) {
      this.route.params.subscribe((params: Params) => {
         this.getSanPhams();    
      });
  }

  ngOnInit() {
    this.getSanPhams();
  }

  getSanPhams() {
    var hangId = this.route.snapshot.paramMap.get('id');
      this.sanPhamService.getSanPhams(hangId).subscribe(
          data => {
              this.sanPhams = data;
          },
          (err: HttpErrorResponse) => {
            if (err.error instanceof Error) {
              console.log('Xảy ra lỗi:', err.error.message);
            } else {
              console.log(`Lỗi kết nối server: ${err.status}, nội dung: ${err.error}`);
            } 
      });
  }

  sapXep(condition: string) {
    log(condition);
    switch(condition) {
      case 'new':
        this.sapXepThoiGianMoiNhat();
        break;
      case 'az':
        this.sapXepGiaTangDan();
        break;
      case 'za':
        this.sapXepGiaGiamDan();
        break;
      default:
        this.sapXepThoiGianMoiNhat();
        break;
    }
  }

  sapXepGiaTangDan() {
    this.sanPhams = this.sanPhams.sort((a:SanPham, b:SanPham) => {
        if(a.giaBan > b.giaBan) {
          return 1;
        }
        else if(a.giaBan < b.giaBan) {
          return -1;
        }
        else {
          return 0;
        }
    });
  }

  sapXepGiaGiamDan() {
    this.sanPhams = this.sanPhams.sort((a:SanPham, b:SanPham) => {
        if(a.giaBan > b.giaBan) {
          return -1;
        }
        else if(a.giaBan < b.giaBan) {
          return 1;
        }
        else {
          return 0;
        }
    });
  }

  sapXepThoiGianMoiNhat() {
    this.sanPhams = this.sanPhams.sort((a:SanPham, b:SanPham) => {
        if(a.ngayDang.getDate > b.ngayDang.getDate) {
          return -1;
        }
        else if(a.giaBan < b.giaBan) {
          return 1;
        }
        else {
          return 0;
        }
    });
  }

  addToCart(event, id) {
    this.shoppingCartService.themSanPhamVaoGioHang(id);    
  }
}
