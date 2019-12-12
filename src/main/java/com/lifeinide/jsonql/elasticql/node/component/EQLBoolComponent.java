package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.query.EQLBool;

/**
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

	public EQLBoolComponent withBool(EQLBool bool) {
		setBool(bool);
		return this;
	}

	public static EQLBoolComponent of(EQLBool bool) {
		return new EQLBoolComponent().withBool(bool);
	}

}
