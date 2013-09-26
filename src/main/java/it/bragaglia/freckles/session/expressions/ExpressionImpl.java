/**
 * 
 */
package it.bragaglia.freckles.session.expressions;

import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.Expression;

import java.util.HashSet;
import java.util.Set;

/**
 * @author stefano
 * 
 */
public abstract class ExpressionImpl implements Expression {

	/**
	 * A flag to keep trick of the first update.
	 */
	private boolean first;

	/**
	 * The followers of the expression.
	 */
	private Set<Expression> followers;

	/**
	 * The actual value of the expression (can be null).
	 */
	private Value value;

	/**
	 * Basic constructor.
	 */
	public ExpressionImpl() {
		this.first = true;
		this.followers = new HashSet<>();
		this.value = null;
		assert invariant() : "Illegal state in ExpressionImpl(Fluent)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.bragaglia.freckles.session.Expression#follow(it.bragaglia.freckles
	 * .session.Expression)
	 */
	@Override
	public void follow(Expression expression) {
		if (expression == null)
			throw new IllegalArgumentException(
					"Illegal 'expression' argument in ExpressionImpl.follow(Expression): "
							+ expression);
		followers.add(expression);
		assert invariant() : "Illegal state in ExpressionImpl.follow(Expression)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.Expression#getValue()
	 */
	@Override
	public Value getValue() {
		assert invariant() : "Illegal state in ExpressionImpl.getValue()";
		return value;
	}

	/**
	 * Invariant check against the internal state.
	 * 
	 * @return <code>true</code> if this instance's state is consistent,
	 *         <code>false</code> otherwise
	 */
	private boolean invariant() {
		return (followers != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.bragaglia.freckles.session.Expression#update(it.bragaglia.freckles
	 * .session.Expression)
	 */
	@Override
	public void update(Expression expression) {
		if (expression == null)
			throw new IllegalArgumentException(
					"Illegal 'expression' argument in ExpressionImpl.update(Expression): "
							+ expression);
		handle(expression.getValue());
		assert invariant() : "Illegal state in ExpressionImpl.update(Expression)";
	}

	@Override
	public void handle(Value value) {
		if (value == null)
			throw new IllegalArgumentException(
					"Illegal 'value' argument in ExpressionImpl.handle(Value): "
							+ value);
		if (first || !value.equals(this.value)) {
			this.value = value;
			first = false;
			for (Expression follower : followers)
				follower.update(this);
		}
		assert invariant() : "Illegal 'value' argument in ExpressionImpl.handle(Value)";
	}

}
