package mobileshop.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mobileshop.entities.HangSanXuat;
import mobileshop.entities.SanPham;
import mobileshop.services.HangSanXuatService;
import mobileshop.services.SanPhamService;

@RestController
@RequestMapping("api")
public class HangSanXuatController {
	
	@Autowired
	HangSanXuatService hangSanXuatService;
	
	@GetMapping("hangsanxuats")
	public List<HangSanXuat> getListHangSanXuat() {
		List<HangSanXuat> list = hangSanXuatService.list();
		return list;
	}

}
