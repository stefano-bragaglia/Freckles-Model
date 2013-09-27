/**
 * 
 */
package it.bragaglia.freckles.model.expressions.operations;

import it.bragaglia.freckles.model.ExpressionDescr;
import it.bragaglia.freckles.model.expressions.OperationDescr;
import it.bragaglia.freckles.session.Expression;
import it.bragaglia.freckles.session.expressions.Operation;
import it.bragaglia.freckles.session.expressions.operations.Times;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author stefano
 * 
 */
public class TimesDescr extends OperationDescr implements ExpressionDescr {

	/**
	 * The cache for operations.
	 */
	private static Map<Expression, Map<Expression, Operation>> operations = new Hashtable<>();

	/**
	 * @param exp1
	 * @param exp2
	 */
	public TimesDescr(ExpressionDescr exp1, ExpressionDescr exp2) {
		super(exp1, exp2);
		assert invariant() : "Illegal state in TimesDescr(ExpressionDescr, ExpressionDescr)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.model.ExpressionDescr#generate()
	 */
	@Override
	public Expression generate() {
		Expression expr1 = getExp1().generate();
		Map<Expression, Operation> operands = operations.get(expr1);
		if (operands == null) {
			operands = new Hashtable<>();
			operations.put(expr1, operands);
		}
		Expression expr2 = getExp2().generate();
		Operation operation = operands.get(expr2);
		if (operation == null) {
			operation = new Times(expr1, expr2);
			operands.put(expr2, operation);
		}
		assert invariant() : "Illegal state in TimesDescr.generate()";
		return operation;
	}

	/**
	 * Invariant check against the internal state.
	 * 
	 * @return <code>true</code> if this instance's state is consistent,
	 *         <code>false</code> otherwise
	 */
	private boolean invariant() {
		return (operations != null);
	}

}