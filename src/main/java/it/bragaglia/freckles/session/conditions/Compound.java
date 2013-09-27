/**
 * 
 */
package it.bragaglia.freckles.session.conditions;

import it.bragaglia.freckles.session.Condition;

/**
 * @author stefano
 * 
 */
public interface Compound extends Condition {

	/**
	 * Returns <code>true</code> if the compound evaluates to <code>true</code>,
	 * <code>false</code> otherwise.
	 * 
	 * @return <code>true</code> if the compound evaluates to <code>true</code>,
	 *         <code>false</code> otherwise
	 */
	public boolean evaluate();

	/**
	 * Returns the number of true conditions.
	 * 
	 * @return the number of true conditions
	 */
	public int getCount();

	/**
	 * Returns the number of conditions.
	 * 
	 * @return the number of conditions
	 */
	public int getSize();

}
