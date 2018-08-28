package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import entities.Regra;
import entities.TipoRegra;

public class RegraRepository {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
	EntityManager em = factory.createEntityManager();
	
	public List<Regra> findAll() {
		//chamando construtor do criteria
		CriteriaBuilder builder = em.getCriteriaBuilder();
		//criando consulta para a classe Regra
		CriteriaQuery<Regra> query = builder.createQuery(Regra.class);
		//buscando campos da classe
		query.from(Regra.class);
		//executando consulta
		TypedQuery<Regra> typedQuery = em.createQuery(query);
		//buscando resultados
		List<Regra> regras = typedQuery.getResultList();
		
		return regras;
	}
	
	public List<Regra> findByTipoRegra(TipoRegra tipoRegra) {
		//chamando construtor do criteria
		CriteriaBuilder builder = em.getCriteriaBuilder();
		//criando consulta para a classe Regra
		CriteriaQuery<Regra> query = builder.createQuery(Regra.class);
		//buscando campos da classe para utilizar no filtro
		Root<Regra> root = query.from(Regra.class);
		//criacao filtro por tipoRegra
		Predicate predicate = builder.equal(root.get("tipoRegra"), tipoRegra);
		//adicionando filtro a consulta
		query.where(predicate);
		//executando consulta
		TypedQuery<Regra> typedQuery = em.createQuery(query);
		//buscando resultados
		List<Regra> regras = typedQuery.getResultList();
		
		return regras;

	}

}
