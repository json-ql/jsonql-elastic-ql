package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.query.EQLValue;

import javax.annotation.Nonnull;

/**
 * {@code type} query component.
 *
 * @author Lukasz Frankowski
 */
public class EQLTypeComponent extends EQLComponent {

	@SerializedName("type")
	protected EQLValue<String> type;

	public EQLValue<String> getType() {
		return type;
	}

	public void setType(EQLValue<String> type) {
		this.type = type;
	}

	@Nonnull public EQLTypeComponent withType(@Nonnull String type) {
		setType(EQLValue.of(type));
		return this;
	}

	@Nonnull public EQLTypeComponent withType(@Nonnull Class type) {
		return withType(type.getName());
	}

	@Nonnull public static EQLTypeComponent of(@Nonnull String type) {
		return new EQLTypeComponent().withType(type);
	}

	@Nonnull public static EQLTypeComponent of(@Nonnull Class type) {
		return new EQLTypeComponent().withType(type);
	}

}
