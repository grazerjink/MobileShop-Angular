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
@Table(name = "san_pham")
public class SanPham implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@Column(name = "ten")
	String ten;
	@Column(name = "hinh")
	String hinh;
	@Column(name = "so_luong")
	Integer soLuong;
	@Column(name = "gia_ban")
	Double giaBan;
	@Column(name = "man_hinh")
	String manHinh;
	@Column(name = "he_dieu_hanh")
	String heDieuHanh;
	@Column(name = "camera_sau")
	String cameraSau;
	@Column(name = "camera_truoc")
	String cameraTruoc;
	@Column(name = "cpu")
	String cpu;
	@Column(name = "ram")
	String ram;
	@Column(name = "rom")
	String rom;
	@Column(name = "the_nho")
	String theNho;
	@Column(name = "the_sim")
	String theSim;
	@Column(name = "pin")
	String pin;
	@Column(name = "mo_ta")
	String moTa;
	@Column(name = "ngay_dang")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	Date ngayDang;
	@Column(name = "trang_thai")
	Boolean trangThai;

	@ManyToOne
	@JoinColumn(name = "hang_id")
	HangSanXuat hang;
	
	@OneToMany(mappedBy = "sanPham")
	Collection<CtHoaDon> ctHoaDons;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
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

	public String getManHinh() {
		return manHinh;
	}

	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}

	public String getHeDieuHanh() {
		return heDieuHanh;
	}

	public void setHeDieuHanh(String heDieuHanh) {
		this.heDieuHanh = heDieuHanh;
	}

	public String getCameraSau() {
		return cameraSau;
	}

	public void setCameraSau(String cameraSau) {
		this.cameraSau = cameraSau;
	}

	public String getCameraTruoc() {
		return cameraTruoc;
	}

	public void setCameraTruoc(String cameraTruoc) {
		this.cameraTruoc = cameraTruoc;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getTheNho() {
		return theNho;
	}

	public void setTheNho(String theNho) {
		this.theNho = theNho;
	}

	public String getTheSim() {
		return theSim;
	}

	public void setTheSim(String theSim) {
		this.theSim = theSim;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public HangSanXuat getHang() {
		return hang;
	}

	public void setHang(HangSanXuat hang) {
		this.hang = hang;
	}

	public Collection<CtHoaDon> getCtHoaDons() {
		return ctHoaDons;
	}

	public void setCtHoaDons(Collection<CtHoaDon> ctHoaDons) {
		this.ctHoaDons = ctHoaDons;
	}

}
