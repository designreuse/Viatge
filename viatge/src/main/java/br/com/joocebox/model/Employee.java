package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_employees")
	private int idEmployees;

	@Column(name="ep_active")
	private byte epActive;

	@Temporal(TemporalType.DATE)
	@Column(name="ep_birth_date")
	private Date epBirthDate;

	@Column(name="ep_email")
	private String epEmail;

	@Column(name="ep_first_name")
	private String epFirstName;

	@Column(name="ep_gender")
	private String epGender;

	@Column(name="ep_last_name")
	private String epLastName;

	@Column(name="ep_photo_path")
	private String epPhotoPath;

	//bi-directional many-to-one association to Department
	@OneToMany(mappedBy="employee")
	private Set<Department> departments;

	//bi-directional many-to-one association to Agency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_agency")
	private Agency agency;

	//bi-directional many-to-one association to EmployeesPhone
	@OneToMany(mappedBy="employee")
	private Set<EmployeesPhone> employeesPhones;

	//bi-directional many-to-one association to SalesTarget
	@OneToMany(mappedBy="employee")
	private Set<SalesTarget> salesTargets;

	public Employee() {
	}

	public int getIdEmployees() {
		return this.idEmployees;
	}

	public void setIdEmployees(int idEmployees) {
		this.idEmployees = idEmployees;
	}

	public byte getEpActive() {
		return this.epActive;
	}

	public void setEpActive(byte epActive) {
		this.epActive = epActive;
	}

	public Date getEpBirthDate() {
		return this.epBirthDate;
	}

	public void setEpBirthDate(Date epBirthDate) {
		this.epBirthDate = epBirthDate;
	}

	public String getEpEmail() {
		return this.epEmail;
	}

	public void setEpEmail(String epEmail) {
		this.epEmail = epEmail;
	}

	public String getEpFirstName() {
		return this.epFirstName;
	}

	public void setEpFirstName(String epFirstName) {
		this.epFirstName = epFirstName;
	}

	public String getEpGender() {
		return this.epGender;
	}

	public void setEpGender(String epGender) {
		this.epGender = epGender;
	}

	public String getEpLastName() {
		return this.epLastName;
	}

	public void setEpLastName(String epLastName) {
		this.epLastName = epLastName;
	}

	public String getEpPhotoPath() {
		return this.epPhotoPath;
	}

	public void setEpPhotoPath(String epPhotoPath) {
		this.epPhotoPath = epPhotoPath;
	}

	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public Department addDepartment(Department department) {
		getDepartments().add(department);
		department.setEmployee(this);

		return department;
	}

	public Department removeDepartment(Department department) {
		getDepartments().remove(department);
		department.setEmployee(null);

		return department;
	}

	public Agency getAgency() {
		return this.agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Set<EmployeesPhone> getEmployeesPhones() {
		return this.employeesPhones;
	}

	public void setEmployeesPhones(Set<EmployeesPhone> employeesPhones) {
		this.employeesPhones = employeesPhones;
	}

	public EmployeesPhone addEmployeesPhone(EmployeesPhone employeesPhone) {
		getEmployeesPhones().add(employeesPhone);
		employeesPhone.setEmployee(this);

		return employeesPhone;
	}

	public EmployeesPhone removeEmployeesPhone(EmployeesPhone employeesPhone) {
		getEmployeesPhones().remove(employeesPhone);
		employeesPhone.setEmployee(null);

		return employeesPhone;
	}

	public Set<SalesTarget> getSalesTargets() {
		return this.salesTargets;
	}

	public void setSalesTargets(Set<SalesTarget> salesTargets) {
		this.salesTargets = salesTargets;
	}

	public SalesTarget addSalesTarget(SalesTarget salesTarget) {
		getSalesTargets().add(salesTarget);
		salesTarget.setEmployee(this);

		return salesTarget;
	}

	public SalesTarget removeSalesTarget(SalesTarget salesTarget) {
		getSalesTargets().remove(salesTarget);
		salesTarget.setEmployee(null);

		return salesTarget;
	}

}