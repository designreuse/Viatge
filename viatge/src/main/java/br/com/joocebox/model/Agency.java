package br.com.joocebox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the agency database table.
 * 
 */
@Entity
@Table(name="login")
@NamedQuery(name="Agency.findAll", query="SELECT a FROM Agency a")
public class Agency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agency")
	private Long idAgency;

	@Column(name="agency_name")
	private String agencyName;
	
	@Column(name="agency_cnpj")
	private String agencyCNPJ;
	
	@Column(name="agency_phone")
	private String agencyPhone;
	
	@Column(name="agency_logo")
	private String agencyLogo;
	
	@Column(name="template_color")
	private String templateColor;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="subdomain")
	private String subdomain;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="active")
	private Boolean active;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	@Column(name="site_template")
	private int siteTemplate;

	public Agency() {
	}
	
	public Long getIdLogin(){
		return idAgency;
	}

	public void setIdLogin(Long idLogin) {
		this.idAgency = idLogin;
	}
	
	@Transient
	public Long getTenantId() {
		return this.idAgency;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSubdomain() {
		return this.subdomain;
	}

	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String login) {
		this.email = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyCNPJ() {
		return agencyCNPJ;
	}

	public void setAgencyCNPJ(String agencyCNPJ) {
		this.agencyCNPJ = agencyCNPJ;
	}
	
	public String getAgencyPhone() {
		return agencyPhone;
	}

	public void setAgencyPhone(String agencyPhone) {
		this.agencyPhone = agencyPhone;
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

	@Override
	public String toString() {
		return "ID=" + idAgency + ", Sub-Dominio=" + subdomain;
	}
}