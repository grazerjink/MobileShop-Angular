package mobileshop.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "hoa_don")
public class HoaDon implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@Column(name = "ten_khach_hang")
	String tenKhachHang;
	@Column(name = "so_dien_thoai")
	String soDienThoai;
	@Column(name = "dia_chi")
	String diaChi;
	@Column(name = "ghi_chu")
	String ghiChu;
	@Column(name = "tong_so_luong")
	Integer tongSoLuong;
	@Column(name = "tong_tien")
	Double tongTien;
	@Column(name = "ngay_lap_phieu")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	Date ngayLapPhieu;
	@Column(name = "trang_thai")
	Boolean trangThai;

	@ManyToOne
	@JoinColumn(name = "tinh_trang_id")
	TinhTrang tinhTrang;
	
	@OneToMany(mappedBy = "hoaDon")
	Collection<CtHoaDon> ctHoaDons;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Integer getTongSoLuong() {
		return tongSoLuong;
	}

	public void setTongSoLuong(Integer tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayLapPhieu() {
		return ngayLapPhieu;
	}

	public void setNgayLapPhieu(Date ngayLapPhieu) {
		this.ngayLapPhieu = ngayLapPhieu;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public TinhTrang getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(TinhTrang tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Collection<CtHoaDon> getCtHoaDons() {
		return ctHoaDons;
	}

	public void setCtHoaDons(Collection<CtHoaDon> ctHoaDons) {
		this.ctHoaDons = ctHoaDons;
	}

}
