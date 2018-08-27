package entities;

import javax.persistence.*;

@Entity
@Table(name = "regras", schema = "req")
public class Regra {
	
	@Id
	@Column(name = "idregras", nullable = false, updatable = false)
	private Integer id;
	
	@ManyToOne(targetEntity = TipoRegra.class)
	@Column(name = "idtiporegra", nullable = false)
	private Integer idTipo;
	
	@Column(name = "nomeregra", nullable = false)
	private String nome;
	
	@Column(name = "descricaoregra", nullable = false)
	private String descricao;
	
	public Regra() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
