import { Component, OnInit } from '@angular/core';
import { SanPham } from '../../../models/san-pham.model';
import { SanPhamService } from '../../../services/san-pham.service';

@Component({
  selector: 'app-best-seller',
  templateUrl: './best-seller.component.html',
  styleUrls: ['./best-seller.component.css']
})
export class BestSellerComponent implements OnInit {

  sanPhamBanChays: SanPham[];

  constructor(private sanPhamService: SanPhamService) { }

  ngOnInit() {
    this.getSanPhamBanChays();
  }

  getSanPhamBanChays() {
    this.sanPhamService.getSanPhamBanChays().subscribe(
        data => { this.sanPhamBanChays = data }
    );
  }

}
