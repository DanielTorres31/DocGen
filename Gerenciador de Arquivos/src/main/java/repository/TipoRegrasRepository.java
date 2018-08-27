package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import entities.TipoRegra;
import persistence.PersistenceManager;

public class TipoRegrasRepository {
	
	private EntityManager em;		
	
	public TipoRegrasRepository() {
		em = PersistenceManager.INSTANCE.getEntityManager();
	}

	
	public List<TipoRegra> findAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoRegra> query = builder.createQuery(TipoRegra.class);
		query.from(TipoRegra.class);
		TypedQuery<TipoRegra> typedQuery = em.createQuery(query);
		
		List<TipoRegra> tipoRegras = typedQuery.getResultList();
		
		return tipoRegras;
	}
	

}
