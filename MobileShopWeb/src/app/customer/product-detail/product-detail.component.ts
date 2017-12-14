import { Component, OnInit, AfterViewInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SanPham } from '../../models/san-pham.model';
import { SanPhamService } from '../../services/san-pham.service';
import { log } from 'util';
import { Params } from '@angular/router/src/shared';

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
    private sanPhamService: SanPhamService
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

  // ngAfterViewInit() {
  //   $("#related_pro").flexslider({animation: "slide",
  //     animationLoop: false,
  //     slideshow: false,
  //     itemWidth: 210,
  //     minItems: this.getGridSize(), // use function to pull in initial value
  //     maxItems: this.getGridSize() // use function to pull in initial value
  //   });
  // }

  // getGridSize() {
  //   return  (window.innerWidth < 320) ? 1 :
  //           (window.innerWidth < 600) ? 2 :
  //           (window.innerWidth < 800) ? 3 :
  //           (window.innerWidth < 900) ? 3 : 4;
  // }

  decreaseQuantity() {
    if(this.soLuong > 1) {
      this.soLuong--;
    }
  }

  increaseQuantity() {
    this.soLuong++;
  }

}
