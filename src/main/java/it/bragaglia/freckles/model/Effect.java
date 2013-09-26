package it.bragaglia.freckles.model;

public interface Effect extends Context {

	/**
	 * Return the context of the effect.
	 * 
	 * @return the context
	 */
	public Context getContext();

	/**
	 * Returns the fluent of the effect.
	 * 
	 * @return the fluent
	 */
	public String getFluent();

}