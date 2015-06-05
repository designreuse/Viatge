package br.com.joocebox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.hash.Hashing;


/**
 * The persistent class for the passenger database table.
 * 
 */
@Entity
@Table(name="passenger")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class Passenger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_passengers")
	private Long id;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;

	@Column(name="birth_date")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Column(name="email")
	private String email;

	@Column(name="first_name")
	@NotEmpty
	private String firstName;

	@Column(name="last_name")
	@NotEmpty
	private String lastName;

	@Column(name="main_tel")
	private String mainTel;


	@Enumerated(EnumType.STRING)
	@Column(name="family_bond")
	private FamilyBond familyBond;

	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_documentPassenger")
	private DocumentPassenger documentPassenger;


	public Passenger() {
	}


	public Long getId() {
		return id;
	}


	public Long getTenantId() {
		return tenantId;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public String getEmail() {
		return email;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getMainTel() {
		return mainTel;
	}


	public FamilyBond getFamilyBond() {
		return familyBond;
	}


	public DocumentPassenger getDocumentPassenger() {
		return documentPassenger;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setMainTel(String mainTel) {
		this.mainTel = mainTel;
	}

	public void setFamilyBond(FamilyBond familyBond) {
		this.familyBond = familyBond;
	}


	public void setDocumentPassenger(DocumentPassenger documentPassenger) {
		this.documentPassenger = documentPassenger;
	}
	
	@Override
	public int hashCode() {
		return Hashing.sha1().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	       if (obj == null) return false;
	        if (getClass() != obj.getClass()) return false;
	        final Passenger other = (Passenger) obj;
	        return Objects.equal(this.lastName, other.lastName)
	            && Objects.equal(this.email, other.email)
	            && Objects.equal(this.firstName, other.firstName)
	            && Objects.equal(this.mainTel, other.mainTel);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Passenger.class)
				.add("Nome do passageiro", getFirstName())
				.add("Email", getEmail()).toString();
	}
}