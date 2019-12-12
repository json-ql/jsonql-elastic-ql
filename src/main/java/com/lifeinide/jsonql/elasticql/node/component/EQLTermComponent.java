package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLField;
import com.lifeinide.jsonql.elasticql.node.query.EQLTermValue;

/**
 * {@code term} query component.
 *
 * @author Lukasz Frankowski
 */
public class EQLTermComponent extends EQLComponent {

	@SerializedName("term")
	protected EQLField<EQLTermValue> term = new EQLField<>();

	public EQLField<EQLTermValue> getTerm() {
		return term;
	}

	public void setTerm(EQLField<EQLTermValue> term) {
		this.term = term;
	}

	public EQLTermComponent withTerm(String field, EQLTermValue term) {
		getTerm().put(field, term);
		return this;
	}

}
