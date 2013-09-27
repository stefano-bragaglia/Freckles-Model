/**
 * 
 */
package it.bragaglia.freckles.model;

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
