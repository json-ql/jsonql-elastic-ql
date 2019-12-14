package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLNode;
import com.lifeinide.jsonql.elasticql.node.component.EQLExistsComponent;

import javax.annotation.Nonnull;

/**
 * A query for {@link EQLExistsComponent}.
 *
 * @author Lukasz Frankowski
 */
public class EQLExistsQuery extends EQLNode {

	@SerializedName("field")
	protected String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Nonnull public EQLExistsQuery withField(@Nonnull String field) {
		setField(field);
		return this;
	}

	@Nonnull public static EQLExistsQuery of(@Nonnull String field) {
		return new EQLExistsQuery().withField(field);
	}

}
