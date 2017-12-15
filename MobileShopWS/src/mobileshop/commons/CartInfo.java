package mobileshop.commons;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import mobileshop.entities.SanPham;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CartInfo {
	Integer idHoaDon;
	public Integer getIdHoaDon() {
		return idHoaDon;
	}
	public void setIdHoaDon(Integer idHoaDon) {
		this.idHoaDon = idHoaDon;
	}
	Double tongTien;
	Integer tongSoLuong;
	Collection<SanPham> sanPhams;
	
	public Double getTongTien() {
		return tongTien;
	}
	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}
	public Integer getTongSoLuong() {
		return tongSoLuong;
	}
	public void setTongSoLuong(Integer tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}
	public Collection<SanPham> getSanPhams() {
		return sanPhams;
	}
	public void setSanPhams(Collection<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	
	
	
}
