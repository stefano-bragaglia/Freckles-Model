/**
 * 
 */
package it.bragaglia.freckles.model.conditions;

import it.bragaglia.freckles.model.ConditionDescr;
import it.bragaglia.freckles.model.ExpressionDescr;

/**
 * @author stefano
 * 
 */
public abstract class RelationDescr implements ConditionDescr {

	/**
	 * 
	 */
	private ExpressionDescr exp1;

	/**
	 * 
	 */
	private ExpressionDescr exp2;

	/**
	 * @param exp1
	 * @param exp2
	 */
	public RelationDescr(ExpressionDescr exp1, ExpressionDescr exp2) {
		if (exp1 == null)
			throw new IllegalArgumentException(
					"Illegal 'exp1' exception in RelationDescr(ExpressionDescr, ExpressionDescr): "
							+ exp1);
		if (exp2 == null)
			throw new IllegalArgumentException(
					"Illegal 'exp2' exception in RelationDescr(ExpressionDescr, ExpressionDescr): "
							+ exp2);
		this.exp1 = exp1;
		this.exp2 = exp2;
		assert invariant() : "Illegal state in RelationDescr(ExpressionDescr, ExpressionDescr)";
	}

	/**
	 * @return
	 */
	private boolean invariant() {
		return (exp1 != null && exp2 != null);
	}

	/**
	 * @return
	 */
	public ExpressionDescr getExp1() {
		assert invariant() : "Illegal state in RelationDescr.getExp1()";
		return exp1;
	}

	/**
	 * @return
	 */
	public ExpressionDescr getExp2() {
		assert invariant() : "Illegal state in RelationDescr.getExp2()";
		return exp2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.ConditionDescr#validate(java.lang.String[])
	 */
	@Override
	public boolean validate(String[] parameters) {
		if (parameters == null)
			throw new IllegalArgumentException(
					"Illegal 'parameters' argument in RelationDescr.validate(String[]): "
							+ parameters);
		boolean result = exp1.validate(parameters) && exp2.validate(parameters);
		assert invariant() : "Illegal state in RelationDescr.validate(String[])";
		return result;
	}

}
