package mobileshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@Table(name = "ct_hoa_don")
public class CtHoaDon {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@Column(name = "so_luong")
	Integer soLuong;
	@Column(name = "gia_ban")
	Double giaBan;
	@Column(name = "thanh_tien")
	Double thanhTien;

	@ManyToOne
	@JoinColumn(name = "hoa_don_id")
	HoaDon hoaDon;

	@ManyToOne
	@JoinColumn(name = "san_pham_id")
	SanPham sanPham;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(Double giaBan) {
		this.giaBan = giaBan;
	}

	public Double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(Double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

}
