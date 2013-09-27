/**
 * 
 */
package it.bragaglia.freckles.session.expressions;

import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.Expression;
import it.bragaglia.freckles.session.ExpressionImpl;

/**
 * @author stefano
 * 
 */
public class Number extends ExpressionImpl implements Expression, Value {

	private double number;

	/**
	 * Basic constructor.
	 * 
	 * @param value
	 */
	public Number(double number) {
		super();
		this.number = number;
		handle(this);
		assert invariant() : "Illegal state in Number(double)";
	}

	/**
	 * @return
	 */
	public double asDouble() {
		assert invariant() : "Illegal state in Number.asDouble()";
		return number;
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

	@Override
	public int compareTo(Value o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Value add(Value value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value subtract(Value value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value multiply(Value value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value divide(Value value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value module(Value value) {
		// TODO Auto-generated method stub
		return null;
	}

}
