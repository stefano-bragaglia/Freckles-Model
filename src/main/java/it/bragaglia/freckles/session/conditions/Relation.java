/**
 * 
 */
package it.bragaglia.freckles.session.conditions;

import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.Condition;
import it.bragaglia.freckles.session.Expression;

/**
 * @author stefano
 * 
 */
public interface Relation extends Condition {

	/**
	 * @return
	 */
	public boolean evaluate();

	/**
	 * @return
	 */
	public Value getValue1();

	/**
	 * @return
	 */
	public Value getValue2();

	/**
	 * @param expression
	 */
	public void update(Expression expression);

}
