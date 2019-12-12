package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLMatchPhrasePrefixComponent;

/**
 * A query for {@link EQLMatchPhrasePrefixComponent}.
 *
 * @author Lukasz Frankowski
 */
public class EQLMatchPhrasePrefixQuery extends EQLQuery {

	@SerializedName("max_expansions")
	protected int maxExpansions = 50;

	public int getMaxExpansions() {
		return maxExpansions;
	}

	public void setMaxExpansions(int maxExpansions) {
		this.maxExpansions = maxExpansions;
	}

	public EQLMatchPhrasePrefixQuery withMaxExpansions(int maxExpansions) {
		setMaxExpansions(maxExpansions);
		return this;
	}

	@Override
	public EQLMatchPhrasePrefixQuery withQuery(String query) {
		return (EQLMatchPhrasePrefixQuery) super.withQuery(query);
	}
}
