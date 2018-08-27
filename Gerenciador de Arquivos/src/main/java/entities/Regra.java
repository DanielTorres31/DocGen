package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "regras", schema = "req")
public class Regra {
	
	@Id
	@Column(name = "idregras", nullable = false, updatable = false)
	private Integer id;
	
	@ManyToOne(targetEntity = TipoRegra.class)
	@JoinColumn(name = "idtiporegra", nullable = false)
	private TipoRegra tipoRegra;
	
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

	public TipoRegra getTipoRegra() {
		return tipoRegra;
	}

	public void setTipoRegra(TipoRegra tipoRegra) {
		this.tipoRegra = tipoRegra;
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
