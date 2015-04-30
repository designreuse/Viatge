package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the year database table.
 * 
 */
@Entity
@Table(name="year")
@NamedQuery(name="Year.findAll", query="SELECT y FROM Year y")
public class Year implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_year")
	private int idYear;

	//bi-directional many-to-one association to Month
	@OneToMany(mappedBy="year")
	private Set<Month> months;

	public Year() {
	}

	public int getIdYear() {
		return this.idYear;
	}

	public void setIdYear(int idYear) {
		this.idYear = idYear;
	}

	public Set<Month> getMonths() {
		return this.months;
	}

	public void setMonths(Set<Month> months) {
		this.months = months;
	}

	public Month addMonth(Month month) {
		getMonths().add(month);
		month.setYear(this);

		return month;
	}

	public Month removeMonth(Month month) {
		getMonths().remove(month);
		month.setYear(null);

		return month;
	}

}