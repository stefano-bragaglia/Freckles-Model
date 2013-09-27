/**
 * 
 */
package it.bragaglia.freckles.model.conditions.relations;

import it.bragaglia.freckles.model.ConditionDescr;
import it.bragaglia.freckles.model.ExpressionDescr;
import it.bragaglia.freckles.model.conditions.RelationDescr;

/**
 * @author stefano
 * 
 */
public class MoreEqualsDescr extends RelationDescr implements ConditionDescr {

	/**
	 * @param exp1
	 * @param exp2
	 */
	public MoreEqualsDescr(ExpressionDescr exp1, ExpressionDescr exp2) {
		super(exp1, exp2);
	}

}
