/**
 * 
 */
package it.bragaglia.freckles;

import it.bragaglia.freckles.model.ContextImpl;
import it.bragaglia.freckles.model.EffectImpl;
import it.bragaglia.freckles.model.Model;
import it.bragaglia.freckles.model.ModelImpl;
import it.bragaglia.freckles.model.conditions.NoCondition;
import it.bragaglia.freckles.model.conditions.relations.SameDescr;
import it.bragaglia.freckles.model.expressions.NumberDescr;
import it.bragaglia.freckles.model.expressions.SampleDescr;

/**
 * @author stefano
 * 
 */
public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Model model = new ModelImpl();
		model.add("TurnOn", new EffectImpl("Switch", new ContextImpl(
				new String[0], new NumberDescr(1), NoCondition.getInstance())));
		model.add("TurnOn", new EffectImpl("Light", new ContextImpl(
				new String[0], new NumberDescr(1), new SameDescr(
						new SampleDescr("Battery"), new NumberDescr(1)))));
		model.add("TurnOff", new EffectImpl("Switch", new ContextImpl(
				new String[0], new NumberDescr(0), NoCondition.getInstance())));
		model.add("TurnOff", new EffectImpl("Light", new ContextImpl(
				new String[0], new NumberDescr(0), NoCondition.getInstance())));
		model.add("PowerOn", new EffectImpl("Battery", new ContextImpl(
				new String[0], new NumberDescr(1), NoCondition.getInstance())));
		model.add("PowerOn", new EffectImpl("Light", new ContextImpl(
				new String[0], new NumberDescr(1), new SameDescr(
						new SampleDescr("Light"), new NumberDescr(1)))));
		model.add("PowerOff", new EffectImpl("Battery", new ContextImpl(
				new String[0], new NumberDescr(0), NoCondition.getInstance())));
		model.add("PowerOff", new EffectImpl("Light", new ContextImpl(
				new String[0], new NumberDescr(0), NoCondition.getInstance())));
		System.out.println(model.toString());
		// TODO Auto-generated method stub
		System.out.println("Done.");
	}
}
