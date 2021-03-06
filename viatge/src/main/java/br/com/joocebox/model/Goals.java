package br.com.joocebox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.hash.Hashing;

@Entity
@Table(name = "goals")
@Multitenant
@TenantDiscriminatorColumn(name = "tenant_id", discriminatorType = DiscriminatorType.INTEGER, contextProperty = PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class Goals implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tenant_id", insertable = false, updatable = false)
	private Long tenantId;

	private String year;
	
	private String january;
	
	private String february;
	
	private String march;
	
	private String april;
	
	private String may;
	
	private String june;
	
	private String july;
	
	private String august;
	
	private String september;
	
	private String october;
	
	private String november;
	
	private String december;

	public Goals() {

	}

	public Goals(String year, String january, String february, String march,
			String april, String may, String june, String july, String august,
			String september, String october, String november, String december) {
		this.year = year;
		this.january = january;
		this.february = february;
		this.march = march;
		this.april = april;
		this.may = may;
		this.june = june;
		this.july = july;
		this.august = august;
		this.september = september;
		this.october = october;
		this.november = november;
		this.december = december;
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


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getJanuary() {
		return january;
	}


	public void setJanuary(String january) {
		this.january = january;
	}


	public String getFebruary() {
		return february;
	}


	public void setFebruary(String february) {
		this.february = february;
	}


	public String getMarch() {
		return march;
	}


	public void setMarch(String march) {
		this.march = march;
	}


	public String getApril() {
		return april;
	}


	public void setApril(String april) {
		this.april = april;
	}


	public String getMay() {
		return may;
	}


	public void setMay(String may) {
		this.may = may;
	}


	public String getJune() {
		return june;
	}


	public void setJune(String june) {
		this.june = june;
	}


	public String getJuly() {
		return july;
	}


	public void setJuly(String july) {
		this.july = july;
	}


	public String getAugust() {
		return august;
	}


	public void setAugust(String august) {
		this.august = august;
	}


	public String getSeptember() {
		return september;
	}


	public void setSeptember(String september) {
		this.september = september;
	}


	public String getOctober() {
		return october;
	}


	public void setOctober(String october) {
		this.october = october;
	}


	public String getNovember() {
		return november;
	}


	public void setNovember(String november) {
		this.november = november;
	}


	public String getDecember() {
		return december;
	}


	public void setDecember(String december) {
		this.december = december;
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
		final Goals other = (Goals) obj;
		return Objects.equal(this.year, other.year)
				&& Objects.equal(this.year, other.year)
				&& Objects.equal(this.january, other.january)
				&& Objects.equal(this.february, other.february)
				&& Objects.equal(this.march, other.march)
				&& Objects.equal(this.april, other.april)
				&& Objects.equal(this.may, other.may)
				&& Objects.equal(this.june, other.june)
				&& Objects.equal(this.july, other.july)
				&& Objects.equal(this.august, other.august)
				&& Objects.equal(this.september, other.september)
				&& Objects.equal(this.october, other.october)
				&& Objects.equal(this.november, other.november)
				&& Objects.equal(this.december, other.december);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Employee.class).add("Ano", getYear())
				.toString();
	}

}