/**
 * 
 */
package it.bragaglia.freckles.session.conditions;

import it.bragaglia.freckles.session.Condition;
import it.bragaglia.freckles.session.ConditionImpl;

/**
 * @author stefano
 * 
 */
public class Not extends ConditionImpl implements Condition {

	/**
	 * Basic constructor. Requires the <code>condition</code> to negate.
	 * 
	 * @param condition
	 *            the condition to negate
	 */
	public Not(Condition condition) {
		super();
		if (condition == null)
			throw new IllegalArgumentException(
					"Illegal 'condition' argument in Not(Condition):  "
							+ condition);
		condition.follow(this);
		assert invariant() : "Illegal state in not(Condition)";
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.bragaglia.freckles.session.ConditionImpl#update(it.bragaglia.freckles
	 * .session.Condition)
	 */
	@Override
	public void update(Condition condition) {
		if (condition == null)
			throw new IllegalArgumentException(
					"Illegal 'condition' argument in Not.update(Condition): "
							+ condition);
		handle(!condition.holds());
		assert invariant() : "Illegal state in Not.update(Condition)";
	}

}
