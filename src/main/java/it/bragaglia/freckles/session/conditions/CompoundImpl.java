/**
 * 
 */
package it.bragaglia.freckles.session.conditions;

import it.bragaglia.freckles.session.Condition;
import it.bragaglia.freckles.session.ConditionImpl;

import java.util.Collection;

/**
 * @author stefano
 * 
 */
public abstract class CompoundImpl extends ConditionImpl implements Compound {

	/**
	 * The number of true conditions.
	 */
	private int count;

	/**
	 * The number of conditions.
	 */
	private int size;

	/**
	 * @param conditions
	 */
	public CompoundImpl(Collection<Condition> conditions) {
		super();
		if (conditions == null)
			throw new IllegalArgumentException(
					"Illegal 'conditions' argument in Compound(Collection<Condition>): "
							+ conditions);
		this.count = 0;
		this.size = conditions.size();
		for (Condition condition : conditions)
			condition.follow(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.conditions.Compound#getCount()
	 */
	@Override
	public int getCount() {
		assert invariant() : "Illegal state in Compound.getCount()";
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.conditions.Compound#getSize()
	 */
	@Override
	public int getSize() {
		assert invariant() : "Illegal state in Compound.getSize()";
		return size;
	}

	/**
	 * Invariant check against the internal state.
	 * 
	 * @return <code>true</code> if this instance's state is consistent,
	 *         <code>false</code> otherwise
	 */
	private boolean invariant() {
		return (0 <= count && count <= size);
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
					"Illegal 'condition' argument in Compound.update(Condition): "
							+ condition);
		if (condition.holds())
			count += 1;
		else
			count -= 1;
		handle(evaluate());
		assert invariant() : "Illegal state in Compound.update(Condition)";
	}

}
