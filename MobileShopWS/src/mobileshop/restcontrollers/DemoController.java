package mobileshop.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mobileshop.entities.TinhTrang;
import mobileshop.services.TinhTrangService;


@RestController
@RequestMapping("api")
public class DemoController {
	@Autowired
	TinhTrangService tinhTrangService;
	
	@GetMapping("lay-danh-sach-tinh-trang")
	public List<TinhTrang> getListString() {
		List<TinhTrang> list = tinhTrangService.list();
		return list;
	}
	
	@PostMapping("add-string")
	public ResponseEntity addString(@RequestParam String value) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add(value);
		return new ResponseEntity(list, HttpStatus.CREATED);
	}
	
	@PutMapping("update-string/{index}")
	public ResponseEntity updateString(@PathVariable Integer index, @RequestParam String newValue) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add(newValue);
		return new ResponseEntity(newValue, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("delete-string/{index}")
	public ResponseEntity deleteString(@PathVariable Integer index) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
