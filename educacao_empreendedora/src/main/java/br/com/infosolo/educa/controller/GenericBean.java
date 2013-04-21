package br.com.infosolo.educa.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.infosolo.educa.domain.Domain;
import br.com.infosolo.educa.domain.UF;

/**
 * Bean generico
 * @author david
 *
 * @param <E>
 */
@SuppressWarnings("rawtypes")
public class GenericBean<E extends Domain> implements Serializable {

	/**
	 * SerialUID.
	 */
	private static final long serialVersionUID = 1L;

	private Stack<String> backStack = new Stack<String>();

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Inject
	protected Conversation conversation;

	public String back() {
		if (!backStack.isEmpty()) {
			return backStack.pop();
		} else {
			return "";
		}
	}

	public void setBack(String value) {
		backStack.push(value);
	}

	public List<UF> getUfs() {
		return Arrays.asList(UF.values());
	}

	@PostConstruct
	public void init() {
		log.info("Inicializando a conversacao no Bean " + this.getClass().getCanonicalName());
		beginConversation();
	}

	@PreDestroy
	public void destroy() {
		log.info("Destruindo o bean " + this.getClass().getCanonicalName() + " Conversation ID: " + getConversation().getId());
	}

	/**
	 * Inicia uma conversação longa.
	 */
	private void beginConversation() {
		if (conversation.isTransient()) {
			conversation.begin();
			log.info("Conversação iniciada - ID:" + conversation.getId());
		}
	}

	public Conversation getConversation() {
		return conversation;
	}

	public List<SelectItem> getNumberPages() {
		return Arrays.asList(new SelectItem[] { new SelectItem(10, "10"),
				new SelectItem(50, "50"), new SelectItem(100, "100"),
				new SelectItem(-1, "Todas") });
	}

}
