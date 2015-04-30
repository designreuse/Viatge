package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the template database table.
 * 
 */
@Entity
@Table(name="template")
@NamedQuery(name="Template.findAll", query="SELECT t FROM Template t")
public class Template implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_template")
	private int idTemplate;

	@Column(name="html_cod")
	private String htmlCod;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="template")
	private Set<Address> addresses;

	//bi-directional many-to-one association to Logo
	@OneToMany(mappedBy="template")
	private Set<Logo> logos;

	//bi-directional many-to-one association to Presentation
	@OneToMany(mappedBy="template")
	private Set<Presentation> presentations;

	//bi-directional many-to-one association to SocialNetwork
	@OneToMany(mappedBy="template")
	private Set<SocialNetwork> socialNetworks;

	//bi-directional many-to-one association to Agency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_agency")
	private Agency agency;

	//bi-directional many-to-one association to TemplateColor
	@OneToMany(mappedBy="template")
	private Set<TemplateColor> templateColors;

	public Template() {
	}

	public int getIdTemplate() {
		return this.idTemplate;
	}

	public void setIdTemplate(int idTemplate) {
		this.idTemplate = idTemplate;
	}

	public String getHtmlCod() {
		return this.htmlCod;
	}

	public void setHtmlCod(String htmlCod) {
		this.htmlCod = htmlCod;
	}

	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setTemplate(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setTemplate(null);

		return address;
	}

	public Set<Logo> getLogos() {
		return this.logos;
	}

	public void setLogos(Set<Logo> logos) {
		this.logos = logos;
	}

	public Logo addLogo(Logo logo) {
		getLogos().add(logo);
		logo.setTemplate(this);

		return logo;
	}

	public Logo removeLogo(Logo logo) {
		getLogos().remove(logo);
		logo.setTemplate(null);

		return logo;
	}

	public Set<Presentation> getPresentations() {
		return this.presentations;
	}

	public void setPresentations(Set<Presentation> presentations) {
		this.presentations = presentations;
	}

	public Presentation addPresentation(Presentation presentation) {
		getPresentations().add(presentation);
		presentation.setTemplate(this);

		return presentation;
	}

	public Presentation removePresentation(Presentation presentation) {
		getPresentations().remove(presentation);
		presentation.setTemplate(null);

		return presentation;
	}

	public Set<SocialNetwork> getSocialNetworks() {
		return this.socialNetworks;
	}

	public void setSocialNetworks(Set<SocialNetwork> socialNetworks) {
		this.socialNetworks = socialNetworks;
	}

	public SocialNetwork addSocialNetwork(SocialNetwork socialNetwork) {
		getSocialNetworks().add(socialNetwork);
		socialNetwork.setTemplate(this);

		return socialNetwork;
	}

	public SocialNetwork removeSocialNetwork(SocialNetwork socialNetwork) {
		getSocialNetworks().remove(socialNetwork);
		socialNetwork.setTemplate(null);

		return socialNetwork;
	}

	public Agency getAgency() {
		return this.agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Set<TemplateColor> getTemplateColors() {
		return this.templateColors;
	}

	public void setTemplateColors(Set<TemplateColor> templateColors) {
		this.templateColors = templateColors;
	}

	public TemplateColor addTemplateColor(TemplateColor templateColor) {
		getTemplateColors().add(templateColor);
		templateColor.setTemplate(this);

		return templateColor;
	}

	public TemplateColor removeTemplateColor(TemplateColor templateColor) {
		getTemplateColors().remove(templateColor);
		templateColor.setTemplate(null);

		return templateColor;
	}

}