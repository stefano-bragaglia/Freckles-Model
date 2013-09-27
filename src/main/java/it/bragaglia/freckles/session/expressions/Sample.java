/**
 * 
 */
package it.bragaglia.freckles.session.expressions;

import it.bragaglia.freckles.session.Expression;
import it.bragaglia.freckles.session.ExpressionImpl;
import it.bragaglia.freckles.session.Fluent;

/**
 * @author stefano
 * 
 */
public class Sample extends ExpressionImpl implements Expression {

	/**
	 * Basic constructor.
	 * 
	 * @param fluent
	 *            the fluent to sample
	 */
	public Sample(Fluent fluent) {
		super();
		// TODO time?
		if (fluent == null)
			throw new IllegalArgumentException(
					"Illegal 'fluent' argument in Sample(Fluent): " + fluent);
		fluent.follow(this);
		assert invariant() : "Illegal state in Sample(Fluent)";
	}

	/**
	 * Invariant check against the internal state.
	 * 
	 * @return <code>true</code> if this instance's state is consistent,
	 *         <code>false</code> otherwise
	 */
	private boolean invariant() {
		// TODO time?
		return (true);
	}

	/**
	 * @param fluent
	 */
	public void update(Fluent fluent) {
		// TODO time?
		if (fluent == null)
			throw new IllegalArgumentException(
					"Illegal 'fluent' argument in Sample.update(Fluent): "
							+ fluent);
		handle(fluent.getValue());
		assert invariant() : "Illegal state in Sample.update(Fluent)";
	}

}
