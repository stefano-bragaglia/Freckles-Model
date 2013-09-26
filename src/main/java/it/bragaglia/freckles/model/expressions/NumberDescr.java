/**
 * 
 */
package it.bragaglia.freckles.model.expressions;

import it.bragaglia.freckles.model.ExpressionDescr;
import it.bragaglia.freckles.session.Expression;
import it.bragaglia.freckles.session.expressions.Number;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author stefano
 * 
 */
public class NumberDescr implements ExpressionDescr {

	/**
	 * The cache for numbers.
	 */
	private static Map<Double, Number> numbers = new Hashtable<>();

	/**
	 * 
	 */
	private double value;

	/**
	 * @param value
	 */
	public NumberDescr(boolean value) {
		this.value = value ? 1.0 : 0.0;
		assert invariant() : "Illegal state in Number(Value)";
	}

	/**
	 * @param value
	 */
	public NumberDescr(byte value) {
		this.value = value;
		assert invariant() : "Illegal state in Number(Value)";
	}

	/**
	 * @param value
	 */
	public NumberDescr(char value) {
		this.value = value;
		assert invariant() : "Illegal state in Number(Value)";
	}

	/**
	 * @param value
	 */
	public NumberDescr(double value) {
		this.value = value;
		assert invariant() : "Illegal state in Number(Value)";
	}

	/**
	 * @param value
	 */
	public NumberDescr(float value) {
		this.value = value;
		assert invariant() : "Illegal state in Number(Value)";
	}

	/**
	 * @param value
	 */
	public NumberDescr(int value) {
		this.value = value;
		assert invariant() : "Illegal state in Number(Value)";
	}

	/**
	 * @param value
	 */
	public NumberDescr(long value) {
		this.value = value;
		assert invariant() : "Illegal state in Number(Value)";
	}

	/**
	 * @param value
	 */
	public NumberDescr(short value) {
		this.value = value;
		assert invariant() : "Illegal state in Number(Value)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.model.ExpressionDescr#generate()
	 */
	@Override
	public Expression generate() {
		Number number = numbers.get(value);
		if (number == null) {
			number = new Number(value);
			numbers.put(value, number);
		}
		assert invariant() : "Illegal state in NumberDescr.generate()";
		return number;
	}

	/**
	 * @return
	 */
	public double getValue() {
		assert invariant() : "Illegal state in Number.getValue()";
		return value;
	}

	/**
	 * @return
	 */
	private boolean invariant() {
		return (numbers != null);
	}

	@Override
	public boolean validate(String[] parameters) {
		if (parameters == null)
			throw new IllegalArgumentException(
					"Illegal 'paramaters' argument in Number,validate(String[]): "
							+ parameters);
		assert invariant() : "Illegal state in Number,validate(String[])";
		return true;
	}

}
