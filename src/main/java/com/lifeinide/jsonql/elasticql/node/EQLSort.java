package com.lifeinide.jsonql.elasticql.node;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.enums.EQLSortOrder;

import javax.annotation.Nonnull;

/**
 * @author Lukasz Frankowski
 */
public class EQLSort extends EQLNode {

	@SerializedName("order")
	protected EQLSortOrder order = EQLSortOrder.asc;

	public EQLSortOrder getOrder() {
		return order;
	}

	public void setOrder(EQLSortOrder order) {
		this.order = order;
	}

	@Nonnull public EQLSort withOrder(@Nonnull EQLSortOrder order) {
		setOrder(order);
		return this;
	}

	@Nonnull public static EQLSort ofAsc() {
		return new EQLSort().withOrder(EQLSortOrder.asc);
	}

	@Nonnull public static EQLSort ofDesc() {
		return new EQLSort().withOrder(EQLSortOrder.desc);
	}


}
