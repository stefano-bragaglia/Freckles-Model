/**
 * 
 */
package it.bragaglia.freckles.model;

import it.bragaglia.freckles.session.Expression;

/**
 * @author stefano
 * 
 */
public interface ExpressionDescr {

	/**
	 * @param parameters
	 * @return
	 */
	public boolean validate(String[] parameters);

	/**
	 * @return
	 */
	public Expression generate();
}
