package Luuloneranger.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
@Entity
@Table(name ="Categories")
public class Catogery implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cate_id")
    private int cateid;
	
	@Column(name="cate_name" , nullable=false, length=250)
	private String catename;
	
	@Column(name = "icons", nullable=true, length=250)
	private String icons;
	
	@Column(name = "Images", nullable=true, length=250)
	private String images;

	public Catogery(int cateid, String catename, String icons, String images) {
		super();
		this.cateid = cateid;
		this.catename = catename;
		this.icons = icons;
		this.images = images;
	}
	public int getCateid() {
		return cateid;
	}

	public void setCateid(int cateid) {
		this.cateid = cateid;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Catogery() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
}
