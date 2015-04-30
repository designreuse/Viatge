package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the logo database table.
 * 
 */
@Entity
@Table(name="template_site")
@NamedQuery(name="TemplateSite.findAll", query="SELECT l FROM TemplateSite l")
public class TemplateSite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="thumb_path")
	private String thumbPath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbPath() {
		return thumbPath;
	}

	public void setThumbPath(String thumbPath) {
		this.thumbPath = thumbPath;
	}

}