package entities;

import javax.persistence.*;

@Entity
@Table(name = "tiporegra", schema = "req")
public class TipoRegra {
	
	@Id
	@Column(name = "idtiporegra", nullable = false, updatable = false )
	private Integer id;
	
	@Column(name = "nometiporegra", nullable = false)
	private String nometiporegra;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNometiporegra() {
		return nometiporegra;
	}

	public void setNometiporegra(String nometiporegra) {
		this.nometiporegra = nometiporegra;
	}
	
	
	
}
