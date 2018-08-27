package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import entities.TipoRegra;

public class TipoRegrasRepository {
	
//	@PersistenceUnit(unitName = "persistenceUnit")
//	private EntityManagerFactory entityManagerFactory;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
	
	private EntityManager em = factory.createEntityManager();		
	
	public List<TipoRegra> findAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoRegra> query = builder.createQuery(TipoRegra.class);
		query.from(TipoRegra.class);
		TypedQuery<TipoRegra> typedQuery = em.createQuery(query);
		
		List<TipoRegra> tipoRegras = typedQuery.getResultList();
		
		return tipoRegras;
	}
	

}
