import { SanPham } from "./san-pham.model";

export interface CartInfo {
    idHoaDon: number;
    tongSoLuong: number;
    tongTien: number;
	sanPhams: SanPham[];
}