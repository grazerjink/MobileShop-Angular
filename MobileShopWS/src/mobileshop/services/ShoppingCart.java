package mobileshop.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import mobileshop.entities.SanPham;

///Id cua Component - cart
@Component("cart") 
///Neu bean nay duoc tao se luu vao session gium luon
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
	
	@Autowired
	SanPhamService sanPhamService;
	
	Map<Integer,SanPham> map = new HashMap<Integer,SanPham>();
	
	/**
	 * Them hang vao gio hang
	 * @param id: la id cua mat hang duoc them
	 * 
	 * */
	public void add(Integer id) {
		SanPham sanPham = map.get(id);
		if(sanPham != null) {
			sanPham.setSoLuong(sanPham.getSoLuong()+1);
		}
		else {
			sanPham = sanPhamService.get(id);
			sanPham.setSoLuong(1);
			map.put(id,sanPham);
		}
	}
	
	/**
	 * Xoa mot mat hang khoi gio hang
	 * @param id: la id cua mat hang bi xoa
	 * */
	public void remove(Integer id) {
		map.remove(id);
	}
	
	/**
	 * Xoa het tat ca cac mat hang khoi gio hang
	 * 
	 * */
	public void clear() {
		map.clear();
	}
	
	/**
	 * Cap nhat so luong cua mat hang vao gio hang
	 * @param id: la id cua mat hang can cap nhat
	 * @param newQuantity: la so luong moi cua mat hang can cap nhat
	 * 
	 * */
	public void update(Integer id, Integer newQuantity) {
		SanPham sanPham = map.get(id);
		sanPham.setSoLuong(newQuantity);
	}
	
	/**
	 * Lay tong so luong mat hang hien dang co trong gio hang
	 * 
	 * */
	public int getCount() {
		int total = 0;
		for(SanPham p : getItems()) {
			total += p.getSoLuong();
		}
		return total;
	}
	
	/**
	 * Lay tong gia tien cua cac mat hang co trong gio hang
	 * 
	 * */
	public double getAmount() {
		double total = 0.00;
		for(SanPham p : getItems()) {
			total += p.getSoLuong()*p.getGiaBan();
		}
		return total;
	}
	
	public SanPham getItem(Integer id) {
		return map.get(id);
	}
	
	/**
	 * Lay danh sach cac mat hang da duoc them vao gio hang
	 * 
	 * */
	public Collection<SanPham> getItems() {
		return map.values();
	}
}
