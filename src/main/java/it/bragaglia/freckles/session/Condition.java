/**
 * 
 */
package it.bragaglia.freckles.session;

/**
 * @author stefano
 * 
 */
public interface Condition {

	/**
	 * @param expression
	 */
	public void follow(Condition condition);

	/**
	 * @return
	 */
	public boolean holds();

	/**
	 * NB: Instead of Value, this allows any operation to distinguish the
	 * operators. The value is determined my calling getValue() on the passed
	 * expression.
	 * 
	 * @param expression
	 */
	public void update(Condition condition);

	/**
	 * @param value
	 */
	public void handle(boolean value);

}
