/**
 * 
 */
package it.bragaglia.freckles.model.conditions.compounds;

import java.util.Iterator;

import it.bragaglia.freckles.model.ConditionDescr;
import it.bragaglia.freckles.model.conditions.CompoundDescr;

/**
 * @author stefano
 * 
 */
public class AndDescr extends CompoundDescr implements ConditionDescr {

	@Override
	public String toString() {
		String result = "";
		Iterator<ConditionDescr> iterator = iterator();
		while (iterator.hasNext()) {
			if (!result.isEmpty())
				result += " & ";
			result += iterator.next();
		}
		return result;
	}

}
