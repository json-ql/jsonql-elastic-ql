package com.lifeinide.jsonql.elasticql.node;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

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
		getFields().put(field, EQLEmptyNode.of());
		return this;
	}

	public static EQLHighlight of(String ... field) {
		EQLHighlight highlight = new EQLHighlight();
		Arrays.stream(field).forEach(highlight::withField);
		return highlight;
	}
	
}
