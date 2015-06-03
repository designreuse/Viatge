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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.hash.Hashing;

@Entity
@Table(name = "employee")
@Multitenant
@TenantDiscriminatorColumn(name = "tenant_id", discriminatorType = DiscriminatorType.INTEGER, contextProperty = PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tenant_id", insertable = false, updatable = false)
	private Long tenantId;

	@NotNull
	@NotEmpty(message = "O Nome não pode estar em branco.")
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@NotEmpty(message = "O Sobrenome não pode estar em branco.")
	@Column(name = "last_name", length=255)
	private String lastName;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "fk_staffContact")
	@Valid
	private StaffContact contact;

	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "A data de nascimento não pode estar em branco.")
	private Date birthDate;

	@Column(name = "gender")
	@NotNull
	@Pattern(regexp = "^[M|F]{1}$", message = "Selecione o sexo do colaborador.")
	private String gender;

	@Column(name="job_title")
	@NotEmpty(message="Informe a função do colaborador.")
	@NotNull
	private String jobTitle;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "fk_login")
	@Valid
	private Login login;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "fk_goal")
	private Goals goal;

	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "avatar")
	private Boolean avatar;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String email,
			StaffContact contact, Date birthDate, String gender,
			String jobTitle, Login login, Goals goal, Boolean active, Boolean avatar) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.birthDate = birthDate;
		this.gender = gender;
		this.jobTitle = jobTitle;
		this.login = login;
		this.goal = goal;
		this.active = active;
		this.avatar = avatar;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Goals getGoal() {
		return goal;
	}

	public void setGoal(Goals goal) {
		this.goal = goal;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getAvatar() {
		return avatar;
	}

	public void setAvatar(Boolean avatar) {
		this.avatar = avatar;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Employee other = (Employee) obj;
		return Objects.equal(this.birthDate, other.birthDate)
				&& Objects.equal(this.firstName, other.firstName)
				&& Objects.equal(this.lastName, other.lastName)
				&& Objects.equal(this.gender, other.gender)
				&& Objects.equal(this.contact, other.contact)
				&& Objects.equal(this.goal, other.goal)
				&& Objects.equal(this.jobTitle, other.jobTitle)
				&& Objects.equal(this.login, other.login)
				&& Objects.equal(this.active, other.active)
				&& Objects.equal(this.avatar, other.avatar);
	}

	@Override
	public String toString() {
		return MoreObjects
				.toStringHelper(Employee.class)
				.add("Nome do Funcionario", getFirstName())
				.add("Sobrenome", getLastName())
				.add("Ativo?", Boolean.TRUE.equals(this.active) ? "Sim" : "Não")
				.toString();
	}

}
