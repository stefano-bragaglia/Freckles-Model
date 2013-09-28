/**
 * 
 */
package it.bragaglia.freckles.model.expressions.operations;

import it.bragaglia.freckles.model.ExpressionDescr;
import it.bragaglia.freckles.model.expressions.OperationDescr;

/**
 * @author stefano
 * 
 */
public class PlusDescr extends OperationDescr implements ExpressionDescr {

	/**
	 * @param exp1
	 * @param exp2
	 */
	public PlusDescr(ExpressionDescr exp1, ExpressionDescr exp2) {
		super(exp1, exp2);
		assert invariant() : "Illegal state in PlusDescr(ExpressionDescr, ExpressionDescr)";
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
