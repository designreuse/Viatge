package br.com.joocebox.repositories.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Article;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.repositories.dao.ArticleBlogDAO;

@Repository
public class ArticleBlogDaoImpl implements ArticleBlogDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;
	
	protected void setCurrentTenant() {
		entityManager.setProperty(PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT, tenantResolver.getCurrentTenantId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> findArticlesByActivesOrderByPostingDateDesc() {
		setCurrentTenant();		
		Query q = entityManager.createQuery("SELECT a FROM Article a"
										 + "  WHERE a.atActive = :p0 "
									   + " ORDER BY a.postingDate DESC");
		q.setParameter("p0", 1);
		return q.getResultList(); 
	}		
}