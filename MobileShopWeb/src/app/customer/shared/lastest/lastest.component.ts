import { Component, OnInit } from '@angular/core';
import { SanPham } from '../../../models/san-pham.model';
import { SanPhamService } from '../../../services/san-pham.service';

@Component({
  selector: 'app-lastest',
  templateUrl: './lastest.component.html',
  styleUrls: ['./lastest.component.css']
})
export class LastestComponent implements OnInit {
  
  sanPhamMois: SanPham[];  

  constructor(private sanPhamService: SanPhamService) { }

  ngOnInit() {
    this.getSanPhamMois();
  }

  getSanPhamMois() {
    this.sanPhamService.getSanPhamMois().subscribe(
        data => { this.sanPhamMois = data }
    );
  }

}
