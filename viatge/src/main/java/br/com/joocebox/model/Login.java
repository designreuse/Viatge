package br.com.joocebox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.hash.Hashing;

@Entity
@Table(name = "login")
public class Login implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tenant_id", insertable = true, updatable = false)
	private Long tenantId;
	
	@Column(name = "email")
	@Email(message="Informe um e-mail válido.")
	@NotEmpty(message = "O E-mail não pode estar vazio")
	private String email;
	
	@Column(name = "password")
	@NotNull(message = "A senha não pode estar em branco.")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Column(name="active")
	private Boolean active;
		
	public Login() {

	}
	
	public Login(String email, String password, Date lastAccess, Role role, Boolean active, Long tenant_id) {
		this.email = email;
		this.password = password;
		this.createDate = lastAccess;
		this.role = role;
		this.active = active;
		this.tenantId = tenant_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getLastAccess() {
		return createDate;
	}

	public void setLastAccess(Date lastAccess) {
		this.createDate = lastAccess;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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
		final Login other = (Login) obj;
		return Objects.equal(this.email, other.email)
				&& Objects.equal(this.password, other.password)
				&& Objects.equal(this.active, other.active)
				&& Objects.equal(this.password, other.password)
				&& Objects.equal(this.role, other.role);

	}

	@Override
	public String toString() {
		return MoreObjects
				.toStringHelper(Login.class)
				.add("E-mail", getEmail())
				.add("Senha", getPassword())
				.add("Ativo?", getActive() ? "Ativo" : "Desativo")
				.add("Papel", getRole().getRole())
				.toString();
	}

}