package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the month database table.
 * 
 */
@Entity
@Table(name="month")
@NamedQuery(name="Month.findAll", query="SELECT m FROM Month m")
public class Month implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_month")
	private int idMonth;

	//bi-directional many-to-one association to SalesTarget
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_sales_target")
	private SalesTarget salesTarget;

	//bi-directional many-to-one association to Year
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_year")
	private Year year;

	public Month() {
	}

	public int getIdMonth() {
		return this.idMonth;
	}

	public void setIdMonth(int idMonth) {
		this.idMonth = idMonth;
	}

	public SalesTarget getSalesTarget() {
		return this.salesTarget;
	}

	public void setSalesTarget(SalesTarget salesTarget) {
		this.salesTarget = salesTarget;
	}

	public Year getYear() {
		return this.year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

}