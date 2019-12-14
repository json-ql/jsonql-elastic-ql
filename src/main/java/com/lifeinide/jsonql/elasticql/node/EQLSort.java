package com.lifeinide.jsonql.elasticql.node;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.enums.EQLSortOrder;

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

	public EQLSort withOrder(EQLSortOrder order) {
		setOrder(order);
		return this;
	}

	public static EQLSort ofAsc() {
		return new EQLSort().withOrder(EQLSortOrder.asc);
	}

	public static EQLSort ofDesc() {
		return new EQLSort().withOrder(EQLSortOrder.desc);
	}


}
