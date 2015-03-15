package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the social_networks database table.
 * 
 */
@Entity
@Table(name="social_networks")
@NamedQuery(name="SocialNetwork.findAll", query="SELECT s FROM SocialNetwork s")
public class SocialNetwork implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_social_networks")
	private int idSocialNetworks;

	@Column(name="fb_link")
	private String fbLink;

	@Column(name="gl_link")
	private String glLink;

	@Column(name="tw_link")
	private String twLink;

	@Column(name="yt_link")
	private String ytLink;

	//bi-directional many-to-one association to Template
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_template")
	private Template template;

	public SocialNetwork() {
	}

	public int getIdSocialNetworks() {
		return this.idSocialNetworks;
	}

	public void setIdSocialNetworks(int idSocialNetworks) {
		this.idSocialNetworks = idSocialNetworks;
	}

	public String getFbLink() {
		return this.fbLink;
	}

	public void setFbLink(String fbLink) {
		this.fbLink = fbLink;
	}

	public String getGlLink() {
		return this.glLink;
	}

	public void setGlLink(String glLink) {
		this.glLink = glLink;
	}

	public String getTwLink() {
		return this.twLink;
	}

	public void setTwLink(String twLink) {
		this.twLink = twLink;
	}

	public String getYtLink() {
		return this.ytLink;
	}

	public void setYtLink(String ytLink) {
		this.ytLink = ytLink;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}