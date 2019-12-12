package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLTermComponent;

/**
 * A query for {@link EQLTermComponent}.
 *
 * @author Lukasz Frankowski
 */
public class EQLTermValue<V> extends EQLValue<V> {

	@SerializedName("boost")
	protected double boost = 1.0;

	public double getBoost() {
		return boost;
	}

	public void setBoost(double boost) {
		this.boost = boost;
	}

	public EQLTermValue<V> withBoost(double boost) {
		setBoost(boost);
		return this;
	}

	@Override
	public EQLTermValue<V> withValue(V value) {
		return (EQLTermValue<V>) super.withValue(value);
	}
}
