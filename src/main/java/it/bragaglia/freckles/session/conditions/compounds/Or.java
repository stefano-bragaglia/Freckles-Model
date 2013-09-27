/**
 * 
 */
package it.bragaglia.freckles.session.conditions.compounds;

import it.bragaglia.freckles.session.Condition;
import it.bragaglia.freckles.session.conditions.Compound;
import it.bragaglia.freckles.session.conditions.CompoundImpl;

import java.util.Collection;

/**
 * @author stefano
 * 
 */
public class Or extends CompoundImpl implements Compound {

	/**
	 * @param conditions
	 */
	public Or(Collection<Condition> conditions) {
		super(conditions);
		// assert invariant() : "Illegal state in Or(Collection<Condition>)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.conditions.Compound#evaluate()
	 */
	@Override
	public boolean evaluate() {
		boolean result = getCount() > 0;
		// assert invariant() : "Illegal state in Or.evaluate()";
		return result;
	}

	// /**
	// * Invariant check against the internal state.
	// *
	// * @return <code>true</code> if this instance's state is consistent,
	// * <code>false</code> otherwise
	// */
	// private boolean invariant() {
	// return (true);
	// }

}
