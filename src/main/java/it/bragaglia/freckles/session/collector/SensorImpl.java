/**
 * 
 */
package it.bragaglia.freckles.session.collector;

import it.bragaglia.freckles.model.Value;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author stefano
 * 
 */
public abstract class SensorImpl implements Sensor {

	/**
	 * 
	 */
	private Set<Collector> collectors;

	/**
	 * 
	 */
	public SensorImpl() {
		this.collectors = new HashSet<>();
		assert invariant() : "Illegal state in SensorImpl()";
	}

	/**
	 * @return
	 */
	private boolean invariant() {
		return (collectors != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.collector.Sensor#clear()
	 */
	@Override
	public void clear() {
		collectors.clear();
		assert invariant() : "Illegal state in SensorImpl.clear()";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.bragaglia.freckles.session.collector.Sensor#report()
	 */
	@Override
	public void report() {
		if (collectors.size() > 0) {
			Map<String, Value> parameters = read();
			for (Collector collector : collectors)
				collector.update(this, parameters);
		}
		assert invariant() : "Illegal state in SensorImpl.report()";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.bragaglia.freckles.session.collector.Sensor#subscribe(it.bragaglia
	 * .freckles.session.collector.Collector)
	 */
	@Override
	public void subscribe(Collector collector) {
		if (collector == null)
			throw new IllegalArgumentException(
					"Illegal 'collector' argument in SensorImpl.subscribe(Collector): "
							+ collector);
		collectors.add(collector);
		assert invariant() : "Illegal state in SensotImpl.subscribe(Collector)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.bragaglia.freckles.session.collector.Sensor#unsubscribe(it.bragaglia
	 * .freckles.session.collector.Collector)
	 */
	@Override
	public void unsubscribe(Collector collector) {
		if (collector == null)
			throw new IllegalArgumentException(
					"Illegal 'collector' argument in SensorImpl.unsubscribe(Collector): "
							+ collector);
		collectors.remove(collector);
		assert invariant() : "Illegal state in SensotImpl.unsubscribe(Collector)";

	}

}
