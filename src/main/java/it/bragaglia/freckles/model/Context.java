package it.bragaglia.freckles.model;

public interface Context {

	/**
	 * Returns the condition of the context.
	 * 
	 * @return the condition
	 */
	public ConditionDescr getCondition();

	/**
	 * Returns the expression of the context.
	 * 
	 * @return the expression
	 */
	public ExpressionDescr getExpression();

	/**
	 * Returns the parameters of the context.
	 * 
	 * @return the parameters
	 */
	public String[] getParameters();

}