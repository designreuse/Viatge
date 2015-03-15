package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sales_target database table.
 * 
 */
@Entity
@Table(name="sales_target")
@NamedQuery(name="SalesTarget.findAll", query="SELECT s FROM SalesTarget s")
public class SalesTarget implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sales_target")
	private int idSalesTarget;

	private String amount;

	//bi-directional many-to-one association to Month
	@OneToMany(mappedBy="salesTarget")
	private Set<Month> months;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_employees")
	private Employee employee;

	public SalesTarget() {
	}

	public int getIdSalesTarget() {
		return this.idSalesTarget;
	}

	public void setIdSalesTarget(int idSalesTarget) {
		this.idSalesTarget = idSalesTarget;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Set<Month> getMonths() {
		return this.months;
	}

	public void setMonths(Set<Month> months) {
		this.months = months;
	}

	public Month addMonth(Month month) {
		getMonths().add(month);
		month.setSalesTarget(this);

		return month;
	}

	public Month removeMonth(Month month) {
		getMonths().remove(month);
		month.setSalesTarget(null);

		return month;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}