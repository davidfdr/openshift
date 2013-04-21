package br.com.infosolo.educa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

/**
 * Objeto que representa a Instituição.
 * 
 * @author david
 *
 */
@Entity
public class Instituicao implements Domain<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4840234444837490141L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Basic(optional = false)
	@Column(name = "descricao")
	@Length(max=100)
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "instituicao", fetch = FetchType.LAZY)
	private List<Participante> participantes = new ArrayList<Participante>(0);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Participante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
}
