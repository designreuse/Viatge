package br.com.joocebox.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The persistent class for the Category of Blog database table.
 * 
 */
@Entity
@Table(name="category_blog")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT) 
public class CategoryBlog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_category_blog")
	private Long idCategoryBlog;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	@Column(name="ct_bg_name")
	@NotEmpty
	@Size(min=3, max=25)
	private String ctBgName;
	
	@Column(name="ct_bg_active")
	private int ctBgActive;
	
	@OneToMany(mappedBy="categoryBlog", fetch = FetchType.LAZY)
	private List<Article> articlesBlog;

	public CategoryBlog() {
	}

	public Long getIdCategoryBlog() {
		return idCategoryBlog;
	}

	public void setIdCategoryBlog(Long idCategoryBlog) {
		this.idCategoryBlog = idCategoryBlog;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getCtBgName() {
		return ctBgName;
	}

	public void setCtBgName(String ctBgName) {
		this.ctBgName = ctBgName;
	}

	public int getCtBgActive() {
		return ctBgActive;
	}

	public void setCtBgActive(int ctBgActive) {
		this.ctBgActive = ctBgActive;
	}	
	
	public List<Article> getArticlesBlog() {
		return articlesBlog;
	}

	public void setArticlesBlog(List<Article> articlesBlog) {
		this.articlesBlog = articlesBlog;
	}

	/**
	 * Retorna quantos artigos estão vinculados a essa categoria.
	 * @return int - Qtd. de artigos.
	 */
	public int getArticlesLinked() {
		if (this.getArticlesBlog() != null && !this.getArticlesBlog().isEmpty()) {
			return this.getArticlesBlog().size();
		} else {
			return 0;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ctBgActive;
		result = prime * result + ((ctBgName == null) ? 0 : ctBgName.hashCode());
		result = prime * result
				+ ((idCategoryBlog == null) ? 0 : idCategoryBlog.hashCode());
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryBlog other = (CategoryBlog) obj;
		if (ctBgActive != other.ctBgActive)
			return false;
		if (ctBgName == null) {
			if (other.ctBgName != null)
				return false;
		} else if (!ctBgName.equals(other.ctBgName))
			return false;
		if (idCategoryBlog == null) {
			if (other.idCategoryBlog != null)
				return false;
		} else if (!idCategoryBlog.equals(other.idCategoryBlog))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryBlog [idCategoryBlog=" + idCategoryBlog + ", ctBgActive=" + ctBgActive
				+ ", ctBgName=" + ctBgName + ", tenantId=" + tenantId + "]";
	}
}