package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.query.EQLBool;

import javax.annotation.Nonnull;

/**
 * {@code bool} query component.
 *
 * @author Lukasz Frankowski
 */
public class EQLBoolComponent extends EQLComponent {

	@SerializedName("bool")
	protected EQLBool bool = new EQLBool();

	public EQLBool getBool() {
		return bool;
	}

	public void setBool(EQLBool bool) {
		this.bool = bool;
	}

	@Nonnull public EQLBoolComponent withBool(@Nonnull EQLBool bool) {
		setBool(bool);
		return this;
	}

	@Nonnull public static EQLBoolComponent of(@Nonnull EQLBool bool) {
		return new EQLBoolComponent().withBool(bool);
	}

}
