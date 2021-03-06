package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLNode;

import javax.annotation.Nonnull;

/**
 * An object with {@code query} field.
 *
 * @author Lukasz Frankowski
 */
public class EQLQuery extends EQLNode {

	@SerializedName("query")
	protected String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Nonnull public EQLQuery withQuery(@Nonnull String query) {
		setQuery(query);
		return this;
	}

}
