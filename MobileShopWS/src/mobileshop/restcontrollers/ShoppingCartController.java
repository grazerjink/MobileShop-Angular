package mobileshop.restcontrollers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mobileshop.entities.SanPham;
import mobileshop.services.ShoppingCart;

@RestController
@RequestMapping("api")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCart cart;
	
	@GetMapping("getcart")
	public Collection<SanPham> getCartInfo() {
		return cart.getItems();
	}
	
	@PostMapping("add")
	public String add(@RequestParam("id") Integer id) {
		cart.add(id);
		String json = String.format("[%d, %.2f]", cart.getCount(), cart.getAmount());
		return json;
	}
	
	@DeleteMapping("remove")
	public String remove(@RequestParam("id") Integer id) {
		cart.remove(id);
		String json = String.format("[%d, %.2f]", cart.getCount(), cart.getAmount());
		return json;
	}
	
	@PutMapping("update")
	public String update(@RequestParam("id") Integer id,
			@RequestParam("qty") Integer newSoLuong) {
		cart.update(id, newSoLuong);
		SanPham p = cart.getItem(id);
		double itemAmount = p.getGiaBan()*p.getSoLuong();	
		String json = String.format("[%d, %.2f, %.2f]", cart.getCount(), cart.getAmount(), itemAmount);
		return json;
	}
	
	@DeleteMapping("clear")
	public String clear(ModelMap model) {
		cart.clear();
		model.addAttribute("cart", cart);
		return "user/shopping-cart/view";
	}
}
