package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLField;
import com.lifeinide.jsonql.elasticql.node.query.EQLMatchQuery;

/**
 * {@code match} query component.
 *
 * @author Lukasz Frankowski
 */
public class EQLMatchComponent extends EQLComponent {

	@SerializedName("match")
	protected EQLField<EQLMatchQuery> match = new EQLField<>();

	public EQLField<EQLMatchQuery> getMatch() {
		return match;
	}

	public void setMatch(EQLField<EQLMatchQuery> match) {
		this.match = match;
	}

	public EQLMatchComponent withMatch(String field, EQLMatchQuery match) {
		getMatch().put(field, match);
		return this;
	}

	public static EQLMatchComponent of(String field, EQLMatchQuery match) {
		return new EQLMatchComponent().withMatch(field, match);
	}

}
