package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employees_phone database table.
 * 
 */
@Entity
@Table(name="employees_phone")
@NamedQuery(name="EmployeesPhone.findAll", query="SELECT e FROM EmployeesPhone e")
public class EmployeesPhone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_employees_phone")
	private int idEmployeesPhone;

	@Column(name="cel_phone")
	private String celPhone;

	@Column(name="home_phone")
	private String homePhone;

	@Column(name="work_phone")
	private String workPhone;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_employees")
	private Employee employee;

	public EmployeesPhone() {
	}

	public int getIdEmployeesPhone() {
		return this.idEmployeesPhone;
	}

	public void setIdEmployeesPhone(int idEmployeesPhone) {
		this.idEmployeesPhone = idEmployeesPhone;
	}

	public String getCelPhone() {
		return this.celPhone;
	}

	public void setCelPhone(String celPhone) {
		this.celPhone = celPhone;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}