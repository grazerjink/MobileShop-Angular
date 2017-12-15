package mobileshop.restcontrollers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mobileshop.commons.CartInfo;
import mobileshop.commons.Constant;
import mobileshop.commons.UserInfo;
import mobileshop.entities.HoaDon;
import mobileshop.entities.TinhTrang;
import mobileshop.services.CtHoaDonService;
import mobileshop.services.HoaDonService;

@RestController
@RequestMapping("api")
public class ShoppingCartController {
	
	@Autowired
	HoaDonService hoaDonService;
	@Autowired
	CtHoaDonService ctHoaDonService;
	
	@PostMapping(value = "taohoadon")
	public ResponseEntity<Integer> thanhToanHoaDon(@RequestBody UserInfo userInfo) {
		try {
			HoaDon hd = new HoaDon();
			hd.setDiaChi(userInfo.getDiaChi());
			hd.setGhiChu(userInfo.getGhiChu());
			hd.setSoDienThoai(userInfo.getSoDienThoai());
			hd.setTenKhachHang(userInfo.getTenKhachHang());
			TinhTrang tt = new TinhTrang();
			tt.setId(Constant.DANG_XU_LY);
			hd.setTinhTrang(tt);
			hd.setNgayLapPhieu(new Date());
			hd.setTrangThai(true);
			hoaDonService.insert(hd);
			return new ResponseEntity<Integer>(hd.getId(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "taochitiethoadon")
	public ResponseEntity thanhToanHoaDon(@RequestBody CartInfo cartInfo) {
		try {
			HoaDon hd = hoaDonService.get(cartInfo.getIdHoaDon());
			hd.setTongSoLuong(cartInfo.getTongSoLuong());
			hd.setTongTien(cartInfo.getTongTien());
			hoaDonService.update(hd);
			ctHoaDonService.purchase(hd,cartInfo.getSanPhams());	
			return new ResponseEntity(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
}
