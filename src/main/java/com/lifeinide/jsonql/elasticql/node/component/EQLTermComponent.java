package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLField;
import com.lifeinide.jsonql.elasticql.node.query.EQLTermQuery;

/**
 * {@code term} query component.
 *
 * @author Lukasz Frankowski
 */
public class EQLTermComponent extends EQLComponent {

	@SerializedName("term")
	protected EQLField<EQLTermQuery> term = new EQLField<>();

	public EQLField<EQLTermQuery> getTerm() {
		return term;
	}

	public void setTerm(EQLField<EQLTermQuery> term) {
		this.term = term;
	}

	public EQLTermComponent withTerm(String field, EQLTermQuery term) {
		getTerm().put(field, term);
		return this;
	}

	public static EQLTermComponent of(String field, EQLTermQuery term) {
		return new EQLTermComponent().withTerm(field, term);
	}

}
