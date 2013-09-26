/**
 * 
 */
package it.bragaglia.freckles.session.collector;

import it.bragaglia.freckles.model.Value;

import java.util.Map;

/**
 * @author stefano
 * 
 */
public interface Sensor {

	/**
	 * 
	 */
	public void clear();

	/**
	 * @return
	 */
	public Map<String, Value> read();

	/**
	 * 
	 */
	public void report();

	/**
	 * @param collector
	 */
	public void subscribe(Collector collector);

	/**
	 * @param collector
	 */
	public void unsubscribe(Collector collector);

}
