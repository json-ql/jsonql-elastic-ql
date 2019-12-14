package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLTermComponent;

import javax.annotation.Nonnull;

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

	@Nonnull public EQLTermQuery<V> withBoost(@Nonnull Double boost) {
		setBoost(boost);
		return this;
	}

	@Override
	@Nonnull public EQLTermQuery<V> withValue(@Nonnull V value) {
		return (EQLTermQuery<V>) super.withValue(value);
	}

	@Nonnull public static <V> EQLTermQuery<V> of(@Nonnull V value) {
		return new EQLTermQuery<V>().withValue(value);
	}
	
}
