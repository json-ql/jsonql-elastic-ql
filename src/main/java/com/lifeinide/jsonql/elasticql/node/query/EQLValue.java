package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLNode;

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

	public EQLValue<V> withValue(V value) {
		setValue(value);
		return this;
	}

}
