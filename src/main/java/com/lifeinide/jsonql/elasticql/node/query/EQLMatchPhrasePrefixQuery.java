package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLMatchPhrasePrefixComponent;

import javax.annotation.Nonnull;

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
	@Nonnull public EQLMatchPhrasePrefixQuery withQuery(@Nonnull String query) {
		return (EQLMatchPhrasePrefixQuery) super.withQuery(query);
	}

	@Nonnull public static EQLMatchPhrasePrefixQuery of(@Nonnull String query) {
		return new EQLMatchPhrasePrefixQuery().withQuery(query);
	}
}
