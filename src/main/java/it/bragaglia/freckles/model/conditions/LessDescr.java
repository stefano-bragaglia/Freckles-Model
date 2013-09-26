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
public class LessDescr extends RelationDescr implements ConditionDescr {

	/**
	 * @param exp1
	 * @param exp2
	 */
	public LessDescr(ExpressionDescr exp1, ExpressionDescr exp2) {
		super(exp1, exp2);
	}

}
