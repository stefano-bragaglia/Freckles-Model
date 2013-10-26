/**
 * 
 */
package it.bragaglia.freckles.model.conditions;

import it.bragaglia.freckles.model.ConditionDescr;

/**
 * @author stefano
 * 
 */
public class NoCondition implements ConditionDescr {

	private static ConditionDescr instance;

	public static ConditionDescr getInstance() {
		if (instance == null)
			instance = new NoCondition();
		return instance;
	}

	private NoCondition() {
	}

	@Override
	public boolean validate(String[] parameters) {
		return true;
	}

	@Override
	public String toString() {
		return "";
	}

}
