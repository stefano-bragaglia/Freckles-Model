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
public abstract class OperationImpl extends ExpressionImpl implements Operation {

	/**
	 * Basic constructor. Requires the first and the second operand
	 * <code>expression</code>.
	 * 
	 * @param expr1
	 *            the first operand expression
	 * @param expr2
	 *            the second operand expression
	 */
	public OperationImpl(Expression expr1, Expression expr2) {
		super();
		if (expr1 == null)
			throw new IllegalArgumentException(
					"Illegal 'expr1' argument in OperationImpl(Expression, Expression): "
							+ expr1);
		if (expr2 == null)
			throw new IllegalArgumentException(
					"Illegal 'expr2' argument in OperationImpl(Expression, Expression): "
							+ expr2);
		this.first1 = true;
		this.first2 = true;
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.val1 = null;
		this.val2 = null;
		expr1.follow(this);
		expr2.follow(this);
		assert invariant() : "Illegal state in OperationImpl(Expression, Expression)";
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

	private Expression expr1;

	private Expression expr2;

	private boolean first1;

	private boolean first2;

	private Value val1;

	private Value val2;

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
		// if (first1 && first2) // because I accept null value.
		handle(evaluate(val1, val2));
		assert invariant() : "Illegal state in OperationImpl.update(Expression)";
	}

}
