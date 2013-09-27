/**
 * 
 */
package it.bragaglia.freckles.session.conditions.relations;

import it.bragaglia.freckles.session.Expression;
import it.bragaglia.freckles.session.conditions.Relation;
import it.bragaglia.freckles.session.conditions.RelationImpl;

/**
 * @author stefano
 * 
 */
public class Different extends RelationImpl implements Relation {

	/**
	 * @param expr1
	 * @param expr2
	 */
	public Different(Expression expr1, Expression expr2) {
		super(expr1, expr2);
		// assert invariant() : "Illegal state in Same(Expression, Expression)";
	}

	// /**
	// * Invariant check against the internal state.
	// *
	// * @return <code>true</code> if this instance's state is consistent,
	// * <code>false</code> otherwise
	// */
	// private boolean invariant() {
	// return (true);
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.conditions.Relation#evaluate()
	 */
	@Override
	public boolean evaluate() {
		boolean result = getValue1().compareTo(getValue2()) != 0;
		// assert invariant() : "Illegal state in Same.evaluate()";
		return result;
	}

}
