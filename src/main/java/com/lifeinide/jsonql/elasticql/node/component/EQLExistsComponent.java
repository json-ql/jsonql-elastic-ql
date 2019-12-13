package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.query.EQLExistsQuery;

/**
 * {@code exists} query component.
 *
 * @author Lukasz Frankowski
 */
public class EQLExistsComponent extends EQLComponent {

	@SerializedName("exists")
	protected EQLExistsQuery exists;

	public EQLExistsQuery getExists() {
		return exists;
	}

	public void setExists(EQLExistsQuery exists) {
		this.exists = exists;
	}

	public EQLExistsComponent withExists(EQLExistsQuery exists) {
		setExists(exists);
		return this;
	}

	public static EQLExistsComponent of(EQLExistsQuery exists) {
		return new EQLExistsComponent().withExists(exists);
	}

}
