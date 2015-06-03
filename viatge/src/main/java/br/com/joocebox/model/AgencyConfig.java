package br.com.joocebox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Bruno Neves
 * 
 * Classe Persistence, contendo os valores de configuração para uma Agência.
 *
 */
@Entity
@Table(name="agency_config")
public class AgencyConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="agency_logo")
	private String agencyLogo;
	
	@Column(name="template_color")
	private String templateColor;

	@Column(name="site_template")
	private int siteTemplate;

	//Contrutor
    public AgencyConfig() {
    }

    //Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgencyLogo() {
		return agencyLogo;
	}

	public void setAgencyLogo(String agencyLogo) {
		this.agencyLogo = agencyLogo;
	}

	public String getTemplateColor() {
		return templateColor;
	}

	public void setTemplateColor(String templateColor) {
		this.templateColor = templateColor;
	}

	public int getSiteTemplate() {
		return siteTemplate;
	}

	public void setSiteTemplate(int siteTemplate) {
		this.siteTemplate = siteTemplate;
	}

    
    
}