/**
 * 
 */
package it.bragaglia.freckles.session;

import java.util.HashSet;
import java.util.Set;

/**
 * @author stefano
 * 
 */
public abstract class ConditionImpl implements Condition {

	/**
	 * A flag to keep track of the first update.
	 */
	private boolean first;

	/**
	 * The followers of the condition.
	 */
	private Set<Condition> followers;

	/**
	 * The actual value of the condition.
	 */
	private boolean value;

	/**
	 * Basic constructor.
	 */
	public ConditionImpl() {
		this.first = true;
		this.followers = new HashSet<>();
		this.value = false;
		assert invariant() : "Illegal state in ExpressionImpl()";
	}

	/**
	 * Invariant check against the internal state.
	 * 
	 * @return <code>true</code> if this instance's state is consistent,
	 *         <code>false</code> otherwise
	 */
	private boolean invariant() {
		return (followers != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.bragaglia.freckles.session.Condition#follow(it.bragaglia.session.Condition
	 * )
	 */
	@Override
	public void follow(Condition condition) {
		if (condition == null)
			throw new IllegalArgumentException(
					"Illegal 'condition' argument in ConditionImpl.follow(Condition): "
							+ condition);
		followers.add(condition);
		assert invariant() : "Illegal state in ConditionImpl.follow(Condition)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.Condition#holds()
	 */
	@Override
	public boolean holds() {
		assert invariant() : "Illegal state in ConditionImpl.holds()";
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.Condition#update(it.bragaglia.freckles
	 * .session.Condition)
	 */
	@Override
	public void update(Condition condition) {
		if (condition == null)
			throw new IllegalArgumentException(
					"Illegal 'condition' argument in ConditionImpl.update(Condition): "
							+ condition);
		handle(condition.holds());
		assert invariant() : "Illegal state in ConditionImpl.update(Condition)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.Condition#handle(boolean)
	 */
	@Override
	public void handle(boolean value) {
		if (first || value != this.value) {
			this.value = value;
			first = false;
			for (Condition follower : followers)
				follower.update(this);
		}
		assert invariant() : "Illegal 'value' argument in ConditionImpl.handle(boolean)";
	}

}
