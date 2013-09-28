/**
 * 
 */
package it.bragaglia.freckles.session;

import it.bragaglia.freckles.model.Context;

import java.util.Map;

/**
 * @author stefano
 * 
 */
public interface Type {

	/**
	 * @param statements 
	 * @return
	 */
	public Session createSession(Map<String, Map<String, Context>> statements);

}
