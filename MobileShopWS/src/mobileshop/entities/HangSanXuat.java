package mobileshop.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "hang_san_xuat")
public class HangSanXuat {

	@Id
	@GeneratedValue
	@Column(name = "id")
	Integer id;
	@Column(name = "ten")
	String ten;
	
	@OneToMany(mappedBy = "hang", fetch = FetchType.LAZY)
	Collection<SanPham> sanPhams;

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

	public Collection<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(Collection<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

}
