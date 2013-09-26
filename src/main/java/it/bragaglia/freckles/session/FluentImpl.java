/**
 * 
 */
package it.bragaglia.freckles.session;

import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.expressions.Sample;

import java.util.Set;
import java.util.TreeMap;

/**
 * The fluent's history of values in chronological order. It may cut the history
 * tail if more computational resources are required. It notifies its observers
 * of any change it
 * 
 * @author stefano
 * 
 */
public class FluentImpl implements Fluent {

	/**
	 * The followers of the fluent.
	 */
	private Set<Sample> followers;

	/**
	 * The temporal history of the fluent.
	 */
	private TreeMap<Long, Value> history;

	/**
	 * A cache for the value before the history (it can be null).
	 */
	private Value value;

	/**
	 * Basic constructor.
	 */
	public FluentImpl() {
		this.history = new TreeMap<>();
		this.value = null;
		assert invariant() : "Illegal state in FluentImpl()";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.Fluent#flush(long)
	 */
	@Override
	public void flush(long time) {
		Long pivot = history.floorKey(time);
		if (pivot != null) {
			value = history.get(pivot);
			history = (TreeMap<Long, Value>) history.tailMap(pivot, false);
		}
		assert invariant() : "Illegal state in FluentImpl.flush(long)";
	}

	@Override
	public void follow(Sample sample) {
		if (sample == null)
			throw new IllegalArgumentException(
					"Illegal 'sample' argument in FluentImpl.register(Sample): "
							+ sample);
		followers.add(sample);
		assert invariant() : "Illegal state in FluentImpl.register(Sample)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.Fluent#getValue()
	 */
	@Override
	public Value getValue() {
		Value result = value;
		if (!history.isEmpty())
			result = history.get(history.lastKey());
		assert invariant() : "Illegal state in FluentImpl.getValue()";
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.Fluent#getValue(long)
	 */
	@Override
	public Value getValue(long time) {
		Long pivot = history.floorKey(time);
		Value result = pivot == null ? value : history.get(pivot);
		assert invariant() : "Illegal state in FluentImpl.getValue(long)";
		return result;
	}

	/**
	 * Invariant check against the internal state.
	 * 
	 * @return <code>true</code> if this instance's state is consistent,
	 *         <code>false</code> otherwise
	 */
	private boolean invariant() {
		return (history != null && followers != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.Fluent#notify(long,
	 * it.bragaglia.freckles.model.Value)
	 */
	@Override
	public void notify(long time, Value value) {
		// NOTE: The value can be null!
		// NOTE: When add all the 'ticks' (new notifications may change MVIs)
		// NOTE: A second tick at the same time overwrites previous value
		// (acceptable)
		Value current = getValue(time);
		history.put(time, value);
		if (!current.equals(value))
			for (Sample follower : followers)
				follower.update(this);
		assert invariant() : "Illegal state in FluentImpl.notify(long, Value)";
	}

}
