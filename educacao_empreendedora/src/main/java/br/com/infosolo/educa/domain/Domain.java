package br.com.infosolo.educa.domain;

import java.io.Serializable;
/**
 * Interface domínio.
 * @author david
 *
 * @param <PK>
 */
public interface Domain<PK extends Serializable> extends Serializable {
	

	PK getId();

	void setId(PK id);
	
}
