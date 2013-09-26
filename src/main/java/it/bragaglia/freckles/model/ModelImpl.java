/**
 * 
 */
package it.bragaglia.freckles.model;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author stefano
 * 
 */
public class ModelImpl implements Model {

	/**
	 * 
	 */
	private Map<String, Map<String, Context>> statements;

	/**
	 * 
	 */
	public ModelImpl() {
		this.statements = new Hashtable<>();
		assert invariant() : "Illegal state in Model()";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.Model#add(java.lang.String,
	 * it.bragaglia.freckles.Effect)
	 */
	@Override
	public void add(String event, Effect... effects) {
		if (event == null || (event = event.trim()).isEmpty())
			throw new IllegalArgumentException(
					"Illegal 'event' argument in ModelImpl.add(String, Effect...): "
							+ event);
		if (effects == null)
			throw new IllegalArgumentException(
					"Illegal 'effects' argument in ModelImpl.add(String, Effect...): "
							+ effects);
		if (effects.length > 0) {
			Map<String, Context> fluents = statements.get(event);
			if (fluents == null) {
				fluents = new Hashtable<>();
				statements.put(event, fluents);
			}
			for (Effect effect : effects)
				fluents.put(effect.getFluent(), effect.getContext());
		}
		assert invariant() : "Illegal state in ModelImpl.add(String, Effect...)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.Model#clear()
	 */
	@Override
	public void clear() {
		statements.clear();
		assert invariant() : "Illegal state in Model.clear()";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.Model#getSession()
	 */
	@Override
	public Session getSession() {
		// TODO
		return null;
	}

	/**
	 * @return
	 */
	private boolean invariant() {
		return (statements != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.Model#remove(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void remove(String event, String... fluents) {
		if (event == null || (event = event.trim()).isEmpty())
			throw new IllegalArgumentException(
					"Illegal 'event' argument in ModelImpl.remove(String, String...): "
							+ event);
		if (fluents == null)
			throw new IllegalArgumentException(
					"Illegal 'fluents' argument in ModelImpl.remove(String, String...): "
							+ fluents);
		if (fluents.length > 0) {
			Map<String, Context> cosos = statements.get(event);
			if (cosos == null) {
				cosos = new Hashtable<>();
				statements.put(event, cosos);
			}
			for (String fluent : fluents)
				cosos.remove(fluent);
		}
		assert invariant() : "Illegal state in ModelImpl.remove(String, String...)";
	}

}