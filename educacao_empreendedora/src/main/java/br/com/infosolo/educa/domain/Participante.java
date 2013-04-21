package br.com.infosolo.educa.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.infosolo.educa.validators.CPF;

/**
 * Classe que representa o objeto Participante.
 * @author david
 *
 */
@Entity
@Table(name="participante")
public class Participante implements Domain<Long> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2554079580831827703L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Basic(optional = false)
	@Column(name = "id")	
	private Long id;
	
	@Basic(optional = false)
    @Column(name = "cpf")
	@NotEmpty(message="Campo obrigat\u00F3rio n\u00E3o preenchido")
	@CPF
	private String cpf;
	
	@Basic(optional = false)
	@Column(name = "nome")
	@NotEmpty(message="Campo obrigat\u00F3rio n\u00E3o preenchido")
	private String nome;
	
	@Basic(optional = false)
	@Column(name = "email")
	@NotEmpty(message="Campo obrigat\u00F3rio n\u00E3o preenchido")
	@Email(message="Deve ser um email válido")
	private String email;
	
	@Basic(optional = false)
	@Column(name = "idade")
	@NotEmpty(message="Campo obrigat\u00F3rio n\u00E3o preenchido")
	private Integer idade;
	
	@Basic(optional = false)
	@Column(name = "cargo")
	@NotEmpty(message="Campo obrigat\u00F3rio n\u00E3o preenchido")
	private String cargo;
	
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
	@Column(name = "uf")
    @NotNull(message="Campo obrigat\u00F3rio n\u00E3o preenchido")
	private UF uf;
        
	@Basic(optional = false)
	@Column(name = "telefone")
	@NotEmpty(message="Campo obrigat\u00F3rio n\u00E3o preenchido")    
	private String telefone;
	
	@Basic(optional = false)
	@Column(name = "evento")
	@NotEmpty(message="Campo obrigat\u00F3rio n\u00E3o preenchido")	
	private Integer evento;
	
	@Basic(optional = false)
	@Column(name = "dt_inclusao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtInclusao;
	
	@Basic(optional = false)
	@Column(name = "nomeCracha")
	@NotEmpty(message="Campo obrigat\u00F3rio n\u00E3o preenchido")	
	private String nomeCracha;
	
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Instituicao instituicao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getEvento() {
		return evento;
	}

	public void setEvento(Integer evento) {
		this.evento = evento;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public String getNomeCracha() {
		return nomeCracha;
	}

	public void setNomeCracha(String nomeCracha) {
		this.nomeCracha = nomeCracha;
	}
	
	
	
	
}
