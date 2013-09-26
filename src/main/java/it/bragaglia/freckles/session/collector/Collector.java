/**
 * 
 */
package it.bragaglia.freckles.session.collector;

import it.bragaglia.freckles.model.Value;
import it.bragaglia.freckles.session.Event;

import java.util.Map;

/**
 * @author stefano
 * 
 */
public interface Collector {

	/**
	 * @param sensor
	 * @param parameters
	 */
	public void update(Sensor sensor, Map<String, Value> parameters);

	/**
	 * @param sensor
	 * @param event
	 */
	public void subscribe(Sensor sensor, Event event);

	/**
	 * @param sensor
	 */
	public void unsubscribe(Sensor sensor, Event event);

}
