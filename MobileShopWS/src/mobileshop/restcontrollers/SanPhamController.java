package mobileshop.restcontrollers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mobileshop.entities.SanPham;
import mobileshop.services.SanPhamService;

@RestController
@RequestMapping("api")
public class SanPhamController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("sanphams")
	public List<SanPham> getListSanPham() {
		List<SanPham> list = sanPhamService.list();
		return list;
	}
	
	@GetMapping("sanphams/{hangId}")
	public List<SanPham> getListSanPhamByHangId(@PathVariable Integer hangId) {
		List<SanPham> list = sanPhamService.listByHangId(hangId);
		return list;
	}
	
	@GetMapping("sanpham/{id}")
	public SanPham getSingleById(@PathVariable Integer id) {
		SanPham sp = sanPhamService.get(id);
		return sp;
	}
	
	@GetMapping("sanphamrelateds/{id}")
	public List<SanPham> getSanPhamRelated(@PathVariable Integer id) {
		List<SanPham> list  = sanPhamService.listRelated(id);
		return list;
	}
	
	@GetMapping("sanphambanchays")
	public List<SanPham> getListSanPhamBanChay() {
		List<SanPham> list = sanPhamService.listBanChay();
		return list;
	}
	
	@GetMapping("sanphammois")
	public List<SanPham> getListSanPhamMoi() {
		List<SanPham> list = sanPhamService.listMoiNhat();
		return list;
	}

}
