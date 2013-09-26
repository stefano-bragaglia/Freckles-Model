/**
 * 
 */
package it.bragaglia.freckles.model;

/**
 * @author stefano
 * 
 */
public class EffectImpl implements Effect {

	/**
	 * The fluent of the effect.
	 */
	private String fluent;

	/**
	 * The context of the effect.
	 */
	private Context context;

	/**
	 * Basic constructor. Requires the <code>fluent</code> and the
	 * <code>context</code> of the effect.
	 * 
	 * @param fluent
	 *            the fluent
	 * @param context
	 *            the context
	 */
	public EffectImpl(String fluent, Context context) {

	}

	/**
	 * Invariant check.
	 * 
	 * @return <code>true</code> if the state is correct, <code>false</code> otherwise
	 */
	private boolean invariant() {
		return (context != null && fluent != null && !fluent.isEmpty());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.Effect#getParameters()
	 */
	@Override
	public String[] getParameters() {
		String[] result = context.getParameters();
		assert invariant() : "Illegal state in EffectImpl.getParameters()";
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.Effect#getExpression()
	 */
	@Override
	public ExpressionDescr getExpression() {
		ExpressionDescr result = context.getExpression();
		assert invariant() : "Illegal state in EffectImpl.getExpression()";
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.Effect#getCondition()
	 */
	@Override
	public ConditionDescr getCondition() {
		ConditionDescr result = context.getCondition();
		assert invariant() : "Illegal state in EffectImpl.getCondition()";
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.Effect#getFluent()
	 */
	@Override
	public String getFluent() {
		assert invariant() : "Illegal state in EffectImpl.getFluent()";
		return fluent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.Effect#getCoso()
	 */
	@Override
	public Context getContext() {
		assert invariant() : "Illegal state in EffectImpl.getCoso()";
		return context;
	}

}
