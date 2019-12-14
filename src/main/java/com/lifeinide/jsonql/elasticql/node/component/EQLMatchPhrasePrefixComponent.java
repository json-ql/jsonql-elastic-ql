package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLField;
import com.lifeinide.jsonql.elasticql.node.query.EQLMatchPhrasePrefixQuery;

import javax.annotation.Nonnull;

/**
 * {@code match_phrase_prefix} query component.
 *
 * @author Lukasz Frankowski
 */
public class EQLMatchPhrasePrefixComponent extends EQLComponent {

	@SerializedName("match_phrase_prefix")
	protected EQLField<EQLMatchPhrasePrefixQuery> matchPhrasePrefix = new EQLField<>();

	public EQLField<EQLMatchPhrasePrefixQuery> getMatchPhrasePrefix() {
		return matchPhrasePrefix;
	}

	public void setMatchPhrasePrefix(EQLField<EQLMatchPhrasePrefixQuery> matchPhrasePrefix) {
		this.matchPhrasePrefix = matchPhrasePrefix;
	}

	@Nonnull public EQLMatchPhrasePrefixComponent withMatchPhrasePrefix(@Nonnull String field, @Nonnull EQLMatchPhrasePrefixQuery matchPhrasePrefix) {
		getMatchPhrasePrefix().put(field, matchPhrasePrefix);
		return this;
	}

	@Nonnull public static EQLMatchPhrasePrefixComponent of(@Nonnull String field, @Nonnull EQLMatchPhrasePrefixQuery matchPhrasePrefix) {
		return new EQLMatchPhrasePrefixComponent().withMatchPhrasePrefix(field, matchPhrasePrefix);
	}

}
