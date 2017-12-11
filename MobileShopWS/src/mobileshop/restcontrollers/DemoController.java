package mobileshop.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mobileshop.entities.TinhTrang;
import mobileshop.services.TinhTrangService;

@RestController
@RequestMapping("api")
public class DemoController {
	@Autowired
	TinhTrangService tinhTrangService;

	@GetMapping("ds-tinhtrang")
	public List<TinhTrang> getListString() {
		List<TinhTrang> list = tinhTrangService.list();
		return list;
	}

	@PostMapping(value = "them-tinhtrang")
	public ResponseEntity themTinhTrang(@RequestBody String moTa) {
		try {
			TinhTrang tt = new TinhTrang();
			tt.setMoTa(moTa);
			tinhTrangService.insert(tt);
			tinhTrangService.refresh(tt);
			return new ResponseEntity(tt, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "sua-tinhtrang")
	public ResponseEntity suaTinhTrang(@RequestBody TinhTrang tinhTrang) {
		try {
			TinhTrang tt = tinhTrangService.get(tinhTrang.getId());
			tt.setMoTa(tinhTrang.getMoTa());
			tinhTrangService.update(tt);
			tinhTrangService.refresh(tt);
			return new ResponseEntity(tt, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "xoa-tinhtrang/{id}")
	public ResponseEntity xoaTinhTrang(@PathVariable Integer id) {
		try {
			TinhTrang tt = tinhTrangService.get(id);
			tinhTrangService.delete(tt);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

}
