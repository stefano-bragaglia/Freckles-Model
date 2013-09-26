/**
 * 
 */
package it.bragaglia.freckles.model.conditions;

import it.bragaglia.freckles.model.ConditionDescr;

/**
 * @author stefano
 * 
 */
public class NotDescr implements ConditionDescr {

	/**
	 * 
	 */
	private ConditionDescr condition;

	/**
	 * @param condition
	 */
	public NotDescr(ConditionDescr condition) {
		if (condition == null)
			throw new IllegalArgumentException(
					"Illegal 'condition' argument in NotDescr(ConditionDescr): "
							+ condition);
		this.condition = condition;
		assert invariant() : "Illegal state in NotDescr(ConditionDescr)";
	}

	/**
	 * @return
	 */
	public ConditionDescr getCondition() {
		assert invariant() : "Illegal state in NotDescr.getCondition()";
		return condition;
	}

	/**
	 * @return
	 */
	private boolean invariant() {
		return (condition != null);
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
					"Illegal 'parameters' argument in NotDescr.validate(String[]): "
							+ parameters);
		boolean result = condition.validate(parameters);
		assert invariant() : "Illegal state in NotDescr.validate(String[])";
		return result;
	}

}
