package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import entities.Regra;

public class RegraRepository {
	EntityManager em;
	
	public List<Regra> findAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Regra> query = builder.createQuery(Regra.class);
		query.from(Regra.class);
		TypedQuery<Regra> typedQuery = em.createQuery(query);
		
		List<Regra> regras = typedQuery.getResultList();
		
		return regras;
	}

}
