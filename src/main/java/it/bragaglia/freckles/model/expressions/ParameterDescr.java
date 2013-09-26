/**
 * 
 */
package it.bragaglia.freckles.model.expressions;

import it.bragaglia.freckles.model.ExpressionDescr;
import it.bragaglia.freckles.session.Expression;
import it.bragaglia.freckles.session.expressions.Parameter;

import java.util.Map;

/**
 * @author stefano
 * 
 */
public class ParameterDescr implements ExpressionDescr {

	/**
	 * 
	 */
	private String name;

	/**
	 * @param name
	 */
	public ParameterDescr(String name) {
		if (name == null || (name = name.trim()).isEmpty())
			throw new IllegalArgumentException(
					"Illegal 'name' argument in Parameter(String): " + name);
		this.name = name;
		assert invariant() : "Illegal state in Parameter(String)";
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
		assert invariant() : "Illegal state in Parameter.getName()";
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
					"Illegal 'parameters' argument in Parameter.validate(String[]): "
							+ parameters);
		boolean result = false;
		for (int i = 0; !result && i < parameters.length; i++)
			result = name.equals(parameters[i]);
		assert invariant() : "Illegal state in Parameter.validate()";
		return result;
	}

	/**
	 * The cache for parameters. (to move in a factory?) Probably more complex:
	 * must keep track of calling event.
	 */
	private static Map<String, Parameter> parameters;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.model.ExpressionDescr#generate()
	 */
	@Override
	public Expression generate() {
		Parameter parameter = parameters.get(name);
		if (parameter == null) {
			parameter = new Parameter(name);
			parameters.put(name, parameter);
		}
		assert invariant() : "Illegal state in ParameterDescr.generate()";
		return parameter;
	}

}
