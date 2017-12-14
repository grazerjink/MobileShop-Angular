import { Component, OnInit, Input } from '@angular/core';
import { SanPham } from '../../../models/san-pham.model';
import { HangSanXuat } from '../../../models/hang-sx.model';
import { HangSanXuatService } from '../../../services/hang-san-xuat.service';
import { SanPhamService } from '../../../services/san-pham.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  
  tieuDe: string = "Danh mục hãng sản xuất";
  hangSanXuats: HangSanXuat[]; 

  constructor(
    private hangSanXuatService: HangSanXuatService,
  ) { }

  ngOnInit() {
    this.getHangSanXuats();
  }

  getHangSanXuats() {
      this.hangSanXuatService.getHangSanXuats().subscribe(
          data => { this.hangSanXuats = data }
      );
  }
}
