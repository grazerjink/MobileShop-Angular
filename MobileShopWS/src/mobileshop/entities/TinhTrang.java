package mobileshop.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tinh_trang")
public class TinhTrang {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@Column(name = "mo_ta")
	String moTa;
	
	@OneToMany(mappedBy = "tinhTrang")
	Collection<HoaDon> hoaDons;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Collection<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(Collection<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

}
