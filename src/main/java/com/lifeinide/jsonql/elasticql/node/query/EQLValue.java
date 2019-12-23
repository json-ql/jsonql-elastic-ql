package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLNode;

import javax.annotation.Nonnull;

/**
 * An object with {@code value} field.
 *
 * @author Lukasz Frankowski
 */
public class EQLValue<V> extends EQLNode {

	@SerializedName("value")
	protected V value;

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Nonnull public EQLValue<V> withValue(@Nonnull V value) {
		setValue(value);
		return this;
	}

	@Nonnull public static <V> EQLValue<V> of(@Nonnull V value) {
		return new EQLValue<V>().withValue(value);
	}

}
