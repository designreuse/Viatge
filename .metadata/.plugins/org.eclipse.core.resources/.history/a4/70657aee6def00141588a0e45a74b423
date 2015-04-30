package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the logo database table.
 * 
 */
@Entity
@Table(name="logo")
@NamedQuery(name="Logo.findAll", query="SELECT l FROM Logo l")
public class Logo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_logo")
	private int idLogo;

	@Column(name="file_name")
	private String fileName;

	@Column(name="logo_path")
	private String logoPath;

	//bi-directional many-to-one association to Template
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_template")
	private Template template;

	public Logo() {
	}

	public int getIdLogo() {
		return this.idLogo;
	}

	public void setIdLogo(int idLogo) {
		this.idLogo = idLogo;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}