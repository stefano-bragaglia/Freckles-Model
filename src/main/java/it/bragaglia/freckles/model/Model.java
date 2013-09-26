package it.bragaglia.freckles.model;

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
	 * Returns a session to handle the model.
	 * 
	 * @return a session
	 */
	public Session getSession();

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