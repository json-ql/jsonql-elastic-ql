package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLMatchPhrasePrefixComponent;

/**
 * A query for {@link EQLMatchPhrasePrefixComponent}.
 *
 * @author Lukasz Frankowski
 */
public class EQLMatchPhrasePrefixQuery extends EQLQuery {

	/** Default: 50 **/
	@SerializedName("max_expansions")
	protected Integer maxExpansions = null;

	public Integer getMaxExpansions() {
		return maxExpansions;
	}

	public void setMaxExpansions(Integer maxExpansions) {
		this.maxExpansions = maxExpansions;
	}

	public EQLMatchPhrasePrefixQuery withMaxExpansions(Integer maxExpansions) {
		setMaxExpansions(maxExpansions);
		return this;
	}

	@Override
	public EQLMatchPhrasePrefixQuery withQuery(String query) {
		return (EQLMatchPhrasePrefixQuery) super.withQuery(query);
	}

	public static EQLMatchPhrasePrefixQuery of(String query) {
		return new EQLMatchPhrasePrefixQuery().withQuery(query);
	}
}
