/**
 * 
 */
package it.bragaglia.freckles.session;

import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.conditions.Relation;

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
	 * @param relation
	 */
	public void follow(Relation relation);

	/**
	 * @return
	 */
	public Value getValue();

	/**
	 * @param value
	 */
	public void handle(Value value);

	/**
	 * NB: Instead of Value, this allows any operation to distinguish the
	 * operators. The value is determined my calling getValue() on the passed
	 * expression.
	 * 
	 * @param expression
	 */
	public void update(Expression expression);

}
