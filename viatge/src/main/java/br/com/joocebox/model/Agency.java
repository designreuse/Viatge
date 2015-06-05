package br.com.joocebox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.Valid;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.hash.Hashing;

@Entity
@Table(name="agency")
public class Agency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="agency_name")
	private String agencyName;
	
	@Column(name="agency_cnpj")
	private String agencyCNPJ;
	
	@Column(name="agency_phone")
	private String agencyPhone;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="subdomain")
	private String subdomain;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_login")
	@Valid
	private Login login;
	
	@Column(name="active")
	private Boolean active;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_agency_config")
	private AgencyConfig agencyConfig;
	
	public Agency() {
		this.setAgencyConfig(new AgencyConfig());
	}
	

	public Agency(String agencyName, String agencyCNPJ, String agencyPhone,
			String agencyLogo, String templateColor, String firstName,
			String lastName, String subdomain, Login login, Boolean active,
			Date creationDate, int siteTemplate) {
		this.agencyName = agencyName;
		this.agencyCNPJ = agencyCNPJ;
		this.agencyPhone = agencyPhone;
		this.setAgencyConfig(new AgencyConfig());
		this.getAgencyConfig().setAgencyLogo(agencyLogo);
		this.getAgencyConfig().setTemplateColor(templateColor);
		this.getAgencyConfig().setSiteTemplate(siteTemplate);
		this.firstName = firstName;
		this.lastName = lastName;
		this.subdomain = subdomain;
		this.login = login;
		this.active = active;
		this.creationDate = creationDate;
	}
	
	public Long getId(){
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Transient
	public Long getTenantId() {
		return this.id;
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
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
	
	public AgencyConfig getAgencyConfig() {
		return agencyConfig;
	}


	public void setAgencyConfig(AgencyConfig agencyConfig) {
		this.agencyConfig = agencyConfig;
	}


	@Override
	public int hashCode() {
		return Hashing.sha1().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Agency other = (Agency) obj;
		return Objects.equal(this.agencyName, other.agencyName)
				&& Objects.equal(this.agencyCNPJ, other.agencyCNPJ)
				&& Objects.equal(this.active, other.active)
				&& Objects.equal(this.agencyPhone, other.agencyPhone)
				&& Objects.equal(this.firstName, other.firstName)
				&& Objects.equal(this.subdomain, other.subdomain);

	}
	
	@Override
	public String toString() {
		return MoreObjects
				.toStringHelper(Agency.class)
				.add("id", getId())
				.add("Nome", getFirstName())
				.add("Ativo?", getActive() ? "Ativo" : "Desativo")
				.add("SubDominio", getSubdomain())
				.toString();
	}

}