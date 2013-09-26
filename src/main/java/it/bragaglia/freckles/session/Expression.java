/**
 * 
 */
package it.bragaglia.freckles.session;

import it.bragaglia.freckles.model.Value;

/**
 * @author stefano
 * 
 */
public interface Expression {

	/**
	 * @param expression
	 */
	public void follow(Expression expression);

	/**
	 * @return
	 */
	public Value getValue();

	/**
	 * NB: Instead of Value, this allows any operation to distinguish the
	 * operators. The value is determined my calling getValue() on the passed
	 * expression.
	 * 
	 * @param expression
	 */
	public void update(Expression expression);
	
	/**
	 * @param value
	 */
	public void handle(Value value);

}
