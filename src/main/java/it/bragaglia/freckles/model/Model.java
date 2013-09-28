package it.bragaglia.freckles.model;

import it.bragaglia.freckles.session.Session;
import it.bragaglia.freckles.session.Type;

public interface Model {

	/**
	 * Adds the contextx for the fluents in the given effects to the given
	 * event.
	 * 
	 * @param event
	 *            the event
	 * @param effects
	 *            the effects
	 */
	public void add(String event, Effect... effects);

	/**
	 * Clears the model.
	 */
	public abstract void clear();

	/**
	 * Returns a session of the given type to handle the model.
	 * 
	 * @param type
	 *            the desired session type to return
	 * @return a session
	 */
	public Session getSession(Type type);

	/**
	 * Removes the contexts for the fluents from the given event.
	 * 
	 * @param event
	 *            the event
	 * @param fluents
	 *            the fluents
	 */
	public void remove(String event, String... fluents);

}