package br.com.joocebox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.format.annotation.DateTimeFormat;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.hash.Hashing;

@Entity
@Table(name="staff")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class Staff implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tenant_id", insertable = false, updatable = false)
	private Long tenantId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastname;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "fk_staffContact")
	private StaffContact contact;
	
	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name="gernder")
	private char gender;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_professionalData")
	private ProfessionalData professionalData;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_goal")
	private Goals goal;

	public Staff() {

	}

	public Staff(String firstName, String lastname, String email,
			StaffContact contact, Date birthDate, char gender,
			ProfessionalData professionalData, Goals goal) {
		this.firstName = firstName;
		this.lastname = lastname;
		this.contact = contact;
		this.birthDate = birthDate;
		this.gender = gender;
		this.professionalData = professionalData;
		this.goal = goal;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public StaffContact getContact() {
		return contact;
	}

	public void setContact(StaffContact contact) {
		this.contact = contact;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public ProfessionalData getProfessionalData() {
		return professionalData;
	}

	public void setProfessionalData(ProfessionalData professionalData) {
		this.professionalData = professionalData;
	}

	public Goals getGoal() {
		return goal;
	}

	public void setGoal(Goals goal) {
		this.goal = goal;
	}

	public Long getId() {
		return id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	@Override
	public int hashCode() {
		return Hashing.sha1().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	       if (obj == null) return false;
	        if (getClass() != obj.getClass()) return false;
	        final Staff other = (Staff) obj;
	        return Objects.equal(this.birthDate, other.birthDate)
	            && Objects.equal(this.firstName, other.firstName)
	            && Objects.equal(this.lastname, other.lastname)
	            && Objects.equal(this.gender, other.gender)
	            && Objects.equal(this.contact, other.contact)
	            && Objects.equal(this.goal, other.goal)
	            && Objects.equal(this.professionalData, other.professionalData);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(ServiceItem.class)
				.add("Nome do Funcionario", getFirstName())
				.add("Sobrenome", getLastname()).toString();
	}

}
