/**
 * 
 */
package it.bragaglia.freckles.model.expressions;

import it.bragaglia.freckles.model.ExpressionDescr;
import it.bragaglia.freckles.session.Expression;
import it.bragaglia.freckles.session.FluentImpl;
import it.bragaglia.freckles.session.expressions.Sample;

import java.util.Hashtable;
import java.util.Map;

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
		return (name != null && !name.isEmpty() && samples != null);
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

	/**
	 * The cache for samples. (to move in a factory?)
	 */
	private static Map<String, Sample> samples = new Hashtable<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.model.ExpressionDescr#generate()
	 */
	@Override
	public Expression generate() {
		Sample sample = samples.get(name);
		if (sample == null) {
			sample = new Sample(new FluentImpl());
			samples.put(name, sample);
		}
		assert invariant() : "Illegal state in SampleDescr.generate()";
		return sample;
	}

}
