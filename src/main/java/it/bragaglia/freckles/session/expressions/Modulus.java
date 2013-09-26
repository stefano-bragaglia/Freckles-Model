/**
 * 
 */
package it.bragaglia.freckles.session.expressions;

import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.Expression;

/**
 * @author stefano
 * 
 */
public class Modulus extends OperationImpl implements Operation {

	/**
	 * @param expr1
	 * @param expr2
	 */
	public Modulus(Expression expr1, Expression expr2) {
		super(expr1, expr2);
		assert invariant() : "Illegal state in Modulus(Expression, Expression)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.bragaglia.freckles.session.expressions.Operation#evaluate(it.bragaglia
	 * .freckles.model.Value, it.bragaglia.freckles.model.Value)
	 */
	@Override
	public Value evaluate(Value val1, Value val2) {
		Value result = val1.module(val2);
		assert invariant() : "Illegal state in Modulus.evaluate(Expression, Expression)";
		return result;
	}

	/**
	 * Invariant check against the internal state.
	 * 
	 * @return <code>true</code> if this instance's state is consistent,
	 *         <code>false</code> otherwise
	 */
	private boolean invariant() {
		return (true);
	}

}
