package br.com.joocebox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The persistent class for the Article of Blog database table.
 * 
 */
@Entity
@Table(name="article_blog")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT) 
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_article")
	private Long idArticle;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	@Column(name="at_name")
	@NotEmpty
	@Size(min=3, max=255)
	private String atName;

	@Column(name="at_content")
	@Lob
	private String atContent;
	
	@Column(name="article_cover")
	private String articleCover;

	@Column(name="at_active")
	private int atActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="posting_date")
	private Date postingDate;

	@OneToOne
	@JoinColumn(name = "fk_category_blog")
	private CategoryBlog categoryBlog;
	
	public Article() {	
		this.setPostingDate(new Date());
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getAtName() {
		return atName;
	}

	public void setAtName(String atName) {
		this.atName = atName;
	}

	public String getArticleCover() {
		return articleCover;
	}

	public void setArticleCover(String articleCover) {
		this.articleCover = articleCover;
	}

	public CategoryBlog getCategoryBlog() {
		return categoryBlog;
	}

	public void setCategoryBlog(CategoryBlog categoryBlog) {
		this.categoryBlog = categoryBlog;
	}
	
	
	public String getAtContent() {
		return atContent;
	}

	public void setAtContent(String atContent) {
		this.atContent = atContent;
	}

	
	public int getAtActive() {
		return atActive;
	}

	public void setAtActive(int atActive) {
		this.atActive = atActive;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atActive;
		result = prime * result + ((atName == null) ? 0 : atName.hashCode());
		result = prime * result
				+ ((idArticle == null) ? 0 : idArticle.hashCode());
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
		Article other = (Article) obj;
		if (atActive != other.atActive)
			return false;
		if (atName == null) {
			if (other.atName != null)
				return false;
		} else if (!atName.equals(other.atName))
			return false;
		if (idArticle == null) {
			if (other.idArticle != null)
				return false;
		} else if (!idArticle.equals(other.idArticle))
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
		return "Article [idArticle=" + idArticle + ", atActive=" + atActive
				+ ", atName=" + atName + ", tenantId=" + tenantId + "]";
	}
	
}