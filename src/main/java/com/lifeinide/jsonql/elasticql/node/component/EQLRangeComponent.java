package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLField;
import com.lifeinide.jsonql.elasticql.node.query.EQLRangeQuery;

/**
 * {@code range} query component.
 *
 * @author Lukasz Frankowski
 */
public class EQLRangeComponent<T> extends EQLComponent {

	@SerializedName("range")
	protected EQLField<EQLRangeQuery<T>> range = new EQLField<>();

	public EQLField<EQLRangeQuery<T>> getRange() {
		return range;
	}

	public void setRange(EQLField<EQLRangeQuery<T>> range) {
		this.range = range;
	}

	public EQLRangeComponent<T> withRange(String field, EQLRangeQuery<T> range) {
		getRange().withField(field, range);
		return this;
	}

	public static <T> EQLRangeComponent<T> of(String field, EQLRangeQuery<T> range) {
		return new EQLRangeComponent<T>().withRange(field, range);
	}

}
