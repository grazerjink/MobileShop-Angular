import { Component, OnInit } from '@angular/core';
import { HangSanXuatService } from '../services/hang-san-xuat.service';
import { HangSanXuat } from '../models/hang-sx.model';
import { Input } from '@angular/core/src/metadata/directives';
import { SanPham } from '../models/san-pham.model';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  
  tieuDe: string = "Danh mục hãng sản xuất";
  hangSanXuats: HangSanXuat[];
  sanPhams: SanPham[];

  constructor(private hangSanXuatService: HangSanXuatService) { }

  ngOnInit() {
    this.getHangSanXuats();
  }

  getHangSanXuats() {
      this.hangSanXuatService.getHangSanXuats().subscribe(
          data => { this.hangSanXuats = data }
      );
  }



}
