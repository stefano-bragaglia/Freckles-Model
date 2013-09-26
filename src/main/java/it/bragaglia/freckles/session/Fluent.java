/**
 * 
 */
package it.bragaglia.freckles.session;

import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.expressions.Sample;


/**
 * @author stefano
 * 
 */
public interface Fluent {

	/**
	 * Cuts the tail of the fluent history of this fluent prior than the given
	 * <code>time</code> and caches the former value.
	 * 
	 * @param time
	 *            the time at which to cut the tail of the fluent history
	 */
	public void flush(long time);

	public void follow(Sample sample);

	/**
	 * Returns the last value of the fluent history, or the cached former value
	 * if the history is empty.
	 * 
	 * @return the last value of the fluent history, or the cached former value
	 *         if the history is empty.
	 */
	public Value getValue();

	/**
	 * Returns the value of the fluent history at the given time, or the cached
	 * former value if it the given time precedes the history.
	 * 
	 * @param time
	 *            the time at which read the value of the fluent history
	 * @return the value of the fluent history at the given time, or the cached
	 *         former value if the given time precedes the history.
	 */
	public Value getValue(long time);

	/**
	 * @param time
	 * @param value
	 */
	public void notify(long time, Value value);

}
