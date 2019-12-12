package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLTermComponent;

/**
 * A query for {@link EQLTermComponent}.
 *
 * @author Lukasz Frankowski
 */
public class EQLTermQuery<V> extends EQLValue<V> {

	/** Default: 1.0 **/
	@SerializedName("boost")
	protected Double boost = null;

	public Double getBoost() {
		return boost;
	}

	public void setBoost(Double boost) {
		this.boost = boost;
	}

	public EQLTermQuery<V> withBoost(Double boost) {
		setBoost(boost);
		return this;
	}

	@Override
	public EQLTermQuery<V> withValue(V value) {
		return (EQLTermQuery<V>) super.withValue(value);
	}

	public static <V> EQLTermQuery<V> of(V value) {
		return new EQLTermQuery<V>().withValue(value);
	}
	
}
