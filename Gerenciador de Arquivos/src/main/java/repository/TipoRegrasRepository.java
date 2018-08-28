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
		//chamando construtor do criteria
		CriteriaBuilder builder = em.getCriteriaBuilder();
		//criando consulta para a classe Regra
		CriteriaQuery<TipoRegra> query = builder.createQuery(TipoRegra.class);
		//buscando campos da classe
		query.from(TipoRegra.class);
		//executando consulta
		TypedQuery<TipoRegra> typedQuery = em.createQuery(query);
		//buscando resultados
		List<TipoRegra> tipoRegras = typedQuery.getResultList();
		
		return tipoRegras;
	}
	

}
