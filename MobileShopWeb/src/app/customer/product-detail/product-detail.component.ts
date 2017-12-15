import { Component, OnInit, AfterViewInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SanPham } from '../../models/san-pham.model';
import { SanPhamService } from '../../services/san-pham.service';
import { log } from 'util';
import { Params } from '@angular/router/src/shared';
import { ShoppingCartService } from '../../services/shopping-cart.service';

declare var $ :any;
@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProductDetailComponent implements OnInit {
  sanPham: SanPham;
  sanPhamRelateds: SanPham[];
  soLuong: number = 1;
  soSanPham = 0;

  constructor(
    private route: ActivatedRoute,
    private sanPhamService: SanPhamService,
    private shoppingCartService: ShoppingCartService
  ) { 
    this.route.params.subscribe((params: Params) => {
      this.getSanPhamById();
      this.getSanPhamRelateds();  
    });
  }

  ngOnInit() {    
  }  

  getSanPhamById() {
    let id = this.route.snapshot.paramMap.get('id');
    this.sanPhamService.getSanPhamById(id).subscribe(
      data => {
        this.sanPham = data
      }
    );    
  }

  getSanPhamRelateds() {
    let id = this.route.snapshot.paramMap.get('id');
    this.sanPhamService.getSanPhamRelateds(id).subscribe(
      data => {
        this.sanPhamRelateds = data,
        console.log(this.sanPhamRelateds)
        this.soSanPham = data.length
      }
    ); 
  }

  themGioHang() {
    this.shoppingCartService.themSanPhamVaSoLuong(this.sanPham, this.soLuong);
  }

  decreaseQuantity() {
    if(this.soLuong > 1) {
      this.soLuong--;
    }
  }

  increaseQuantity() {
    this.soLuong++;
  }

}
