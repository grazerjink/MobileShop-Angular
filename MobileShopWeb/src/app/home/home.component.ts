import { Component, OnInit } from '@angular/core';
import { TinhTrangService } from '../services/tinh-trang.service';
import { log } from 'util';
import { TinhTrang } from '../models/tinh-trang.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  tinhTrangs: TinhTrang[]; 

  constructor(private tinhTrangService: TinhTrangService) { }

  ngOnInit() {

  }

  // getTinhTrangs() {
  //   this.tinhTrangService.getTinhTrangs().subscribe(tinhTrangs => this.tinhTrangs = tinhTrangs);
  // }

  // addTinhTrang() {
  //   let moTa: string = "ABC";
  //   this.tinhTrangService.addTinhTrang(moTa).subscribe(tt => console.log(tt));
  // }

  // editTinhTrang() {
  //   let tinhTrang: TinhTrang = {
  //     id: 7,
  //     moTa: "CDE"
  //   }
  //   this.tinhTrangService.editTinhTrang(tinhTrang).subscribe(tt => console.log(tt));
  // }

  // removeTinhTrang() {
  //   this.tinhTrangService.removeTinhTrang(8).subscribe(tt => console.log(tt));
  // }

}
