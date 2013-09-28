/**
 * 
 */
package it.bragaglia.freckles.model.expressions;

import it.bragaglia.freckles.model.ExpressionDescr;

/**
 * @author stefano
 * 
 */
public class SampleDescr implements ExpressionDescr {

	/**
	 * 
	 */
	private String name;

	/**
	 * @param name
	 */
	public SampleDescr(String name) {
		if (name == null || (name = name.trim()).isEmpty())
			throw new IllegalArgumentException(
					"Illegal 'name' argument in SampleDescr(String): " + name);
		this.name = name;
		assert invariant() : "Illegal state in SampleDescr(String)";
	}

	/**
	 * @return
	 */
	private boolean invariant() {
		return (name != null && !name.isEmpty());
	}

	/**
	 * @return
	 */
	public String getName() {
		assert invariant() : "Illegal state in SampleDescr.getName()";
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.Expression#validate(java.lang.String[])
	 */
	@Override
	public boolean validate(String[] parameters) {
		if (parameters == null)
			throw new IllegalArgumentException(
					"Illegal 'parameters' argument in SampleDescr.validate(String[]): "
							+ parameters);
		assert invariant() : "Illegal state in SampleDescr.validate()";
		return true;
	}

}
