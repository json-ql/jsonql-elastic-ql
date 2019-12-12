package com.lifeinide.jsonql.elasticql.node;

import com.google.gson.annotations.SerializedName;

/**
 * Highlight component of {@link EQLRoot} query.
 *
 * @author Lukasz Frankowski
 */
public class EQLHighlight extends EQLNode {

	@SerializedName("fields")
	protected EQLFields<EQLEmptyNode> fields = new EQLFields<>();

	public EQLFields<EQLEmptyNode> getFields() {
		return fields;
	}

	public void setFields(EQLFields<EQLEmptyNode> fields) {
		this.fields = fields;
	}

	public EQLHighlight withField(String field) {
		getFields().put(field, new EQLEmptyNode());
		return this;
	}
	
}
