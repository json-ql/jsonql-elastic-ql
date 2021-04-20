package com.lifeinide.jsonql.elasticql.node.component;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLEmptyNode;

import javax.annotation.Nonnull;

/**
 * {@code match_all} query component.
 *
 * @author Lukasz Frankowski
 */
public class EQLMatchAllComponent extends EQLComponent {

	@SerializedName("match_all")
	protected EQLEmptyNode matchAll = EQLEmptyNode.of();

	public EQLEmptyNode getMatchAll() {
		return matchAll;
	}

	@Nonnull public static EQLMatchAllComponent of() {
		return new EQLMatchAllComponent();
	}

}
