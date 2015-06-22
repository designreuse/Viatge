package br.com.joocebox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name="facebook_link")
	private String facebookLink;
	
	@Column(name="twitter_link")
	private String twitterLink;
	
	@Column(name="instagram_link")
	private String instagramLink;
	
	@Column(name="googlePlus_link")
	private String googlePlusLink;
	
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
	
	public String getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	public String getTwitterLink() {
		return twitterLink;
	}

	public void setTwitterLink(String twitterLink) {
		this.twitterLink = twitterLink;
	}

	public String getInstagramLink() {
		return instagramLink;
	}

	public void setInstagramLink(String instagramLink) {
		this.instagramLink = instagramLink;
	}

	public String getGooglePlusLink() {
		return googlePlusLink;
	}

	public void setGooglePlusLink(String googlePlusLink) {
		this.googlePlusLink = googlePlusLink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgencyConfig other = (AgencyConfig) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}