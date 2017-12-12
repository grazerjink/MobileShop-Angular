package mobileshop.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
