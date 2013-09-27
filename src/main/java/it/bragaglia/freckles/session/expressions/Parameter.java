/**
 * 
 */
package it.bragaglia.freckles.session.expressions;


import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.Expression;
import it.bragaglia.freckles.session.ExpressionImpl;

import java.util.Map;

/**
 * @author stefano
 * 
 */
public class Parameter extends ExpressionImpl implements Expression {

	/**
	 * The name of the parameter.
	 */
	private String name;

	/**
	 * Basic constructor. Requires the name of the parameter to access.
	 * 
	 * @param name
	 *            the name of the parameter
	 */
	public Parameter(String name) {
		super();
		if (name == null || (name = name.trim()).isEmpty())
			throw new IllegalArgumentException(
					"Illegal 'name' argument in Parameter(String): " + name);
		this.name = name;
		assert invariant() : "Illegal state in Parameter(String)";
	}

	/**
	 * Invariant check against the internal state.
	 * 
	 * @return <code>true</code> if this instance's state is consistent,
	 *         <code>false</code> otherwise
	 */
	private boolean invariant() {
		return (name != null && !name.isEmpty());
	}
	
	public void update(Map<String, Value> parameters) {
		if (parameters == null)
			throw new IllegalArgumentException(
					"Illegal 'parameters' argument in Sample.update(Map<String, Value>): "
							+ parameters);
		// TODO more refined control?
		handle(parameters.get(name));
		assert invariant() : "Illegal state in Sample.update(Map<String, Value>)";
	}


}
