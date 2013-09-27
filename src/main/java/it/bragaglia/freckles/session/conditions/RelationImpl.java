/**
 * 
 */
package it.bragaglia.freckles.session.conditions;

import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.ConditionImpl;
import it.bragaglia.freckles.session.Expression;

/**
 * @author stefano
 * 
 */
public abstract class RelationImpl extends ConditionImpl implements Relation {

	private Expression expr1;

	private Expression expr2;

	private boolean first1;

	private boolean first2;

	private Value val1;

	private Value val2;

	/**
	 * Basic constructor. Requires the first and the second comparison
	 * <code>expression</code>.
	 * 
	 * @param expr1
	 *            the first comparison expression
	 * @param expr2
	 *            the second comparison expression
	 */
	public RelationImpl(Expression expr1, Expression expr2) {
		super();
		if (expr1 == null)
			throw new IllegalArgumentException(
					"Illegal 'expr1' argument in RelationImpl(Expression, Expression): "
							+ expr1);
		if (expr2 == null)
			throw new IllegalArgumentException(
					"Illegal 'expr2' argument in RelationImpl(Expression, Expression): "
							+ expr2);
		this.first1 = true;
		this.first2 = true;
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.val1 = null;
		this.val2 = null;
		expr1.follow(this);
		expr2.follow(this);
		assert invariant() : "Illegal state in RelationImpl(Expression, Expression)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.conditions.Relation#getValue1()
	 */
	@Override
	public Value getValue1() {
		assert invariant() : "Illegal state in RelationImpl.getValue1()";
		return val1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.conditions.Relation#getValue2()
	 */
	@Override
	public Value getValue2() {
		assert invariant() : "Illegal state in RelationImpl.getValue2()";
		return val2;
	}

	/**
	 * Invariant check against the internal state.
	 * 
	 * @return <code>true</code> if this instance's state is consistent,
	 *         <code>false</code> otherwise
	 */
	private boolean invariant() {
		return (expr1 != null && expr2 != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.bragaglia.freckles.session.conditions.Relation#update(it.bragaglia
	 * .freckles.session.Expression)
	 */
	@Override
	public void update(Expression expression) {
		if (expression == null)
			throw new IllegalArgumentException(
					"Illegal 'expression' argument in ExpressionImpl.update(Expression): "
							+ expression);
		Value current = expression.getValue();
		if (expression.equals(expr1) && (first1 || !val1.equals(current))) {
			this.val1 = current;
			first1 = false;
		}
		if (expression.equals(expr2) && (first2 || !val2.equals(current))) {
			this.val2 = current;
			first2 = false;
		}
		// if (first1 && first2) // removed because I accept null values.
		handle(evaluate());
		assert invariant() : "Illegal state in OperationImpl.update(Expression)";
	}

}
