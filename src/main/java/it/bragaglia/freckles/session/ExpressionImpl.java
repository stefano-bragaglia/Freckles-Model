/**
 * 
 */
package it.bragaglia.freckles.session;

import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.conditions.Relation;

import java.util.HashSet;
import java.util.Set;

/**
 * @author stefano
 * 
 */
public abstract class ExpressionImpl implements Expression {

	/**
	 * The <code>Expression</code> followers of the expression.
	 */
	private Set<Expression> expressions;

	/**
	 * A flag to keep track of the first update.
	 */
	private boolean first;

	/**
	 * The <code>Relation</code> followers of the expression.
	 */
	private Set<Relation> relations;

	/**
	 * The actual value of the expression (can be null).
	 */
	private Value value;

	/**
	 * Basic constructor.
	 */
	public ExpressionImpl() {
		this.expressions = new HashSet<>();
		this.first = true;
		this.relations = new HashSet<>();
		this.value = null;
		assert invariant() : "Illegal state in ExpressionImpl()";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.bragaglia.freckles.session.Expression#follow(it.bragaglia.freckles
	 * .session.conditions.Relation)
	 */
	@Override
	public void follow(Relation relation) {
		if (relation == null)
			throw new IllegalArgumentException(
					"Illegal 'relation' argument in ExpressionImpl.follow(Relation): "
							+ relation);
		relations.add(relation);
		assert invariant() : "Illegal state in ExpressionImpl.follow(Relation)";
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
		expressions.add(expression);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.bragaglia.freckles.session.Expression#handle(it.bragaglia.freckles
	 * .model.Value)
	 */
	@Override
	public void handle(Value value) {
		if (value == null)
			throw new IllegalArgumentException(
					"Illegal 'value' argument in ExpressionImpl.handle(Value): "
							+ value);
		if (first || !value.equals(this.value)) {
			this.value = value;
			first = false;
			for (Expression follower : expressions)
				follower.update(this);
			for (Relation follower : relations)
				follower.update(this);
		}
		assert invariant() : "Illegal 'value' argument in ExpressionImpl.handle(Value)";
	}

	/**
	 * Invariant check against the internal state.
	 * 
	 * @return <code>true</code> if this instance's state is consistent,
	 *         <code>false</code> otherwise
	 */
	private boolean invariant() {
		return (expressions != null);
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

}
