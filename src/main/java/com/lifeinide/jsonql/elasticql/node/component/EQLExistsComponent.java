package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.query.EQLExistsQuery;

import javax.annotation.Nonnull;

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

	@Nonnull public EQLExistsComponent withExists(@Nonnull EQLExistsQuery exists) {
		setExists(exists);
		return this;
	}

	@Nonnull public static EQLExistsComponent of(@Nonnull EQLExistsQuery exists) {
		return new EQLExistsComponent().withExists(exists);
	}

}
