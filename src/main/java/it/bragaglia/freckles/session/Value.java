/**
 * 
 */
package it.bragaglia.freckles.session;

/**
 * @author stefano
 * 
 */
public interface Value extends Comparable<Value> {

	public Value add(Value value);

	public Value subtract(Value value);

	public Value multiply(Value value);

	public Value divide(Value value);

	public Value module(Value value);

}
