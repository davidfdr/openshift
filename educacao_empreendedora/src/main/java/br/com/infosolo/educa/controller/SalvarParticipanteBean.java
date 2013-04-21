package br.com.infosolo.educa.controller;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.infosolo.educa.domain.Participante;

/**
 * Bean responsável pelas operações
 * de salvar participante.
 * @author david
 *
 */
@Named
@ConversationScoped
public class SalvarParticipanteBean extends GenericBean<Participante> {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8955049236114727760L;
	
	private Participante participante;
	
	private String confirmacaoEmail;
	
	private String formulario;

	public Participante getParticipante() {
		if(participante == null){
			participante = new Participante();
		}
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public String getConfirmacaoEmail() {
		return confirmacaoEmail;
	}

	public void setConfirmacaoEmail(String confirmacaoEmail) {
		this.confirmacaoEmail = confirmacaoEmail;
	}

	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}
	
	public void salvarParticipante(){
		log.info("Formulario: {}",formulario);
	}

}
