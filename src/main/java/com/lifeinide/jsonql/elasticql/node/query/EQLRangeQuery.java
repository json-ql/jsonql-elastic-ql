package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLNode;
import com.lifeinide.jsonql.elasticql.node.component.EQLRangeComponent;

/**
 * A query for {@link EQLRangeComponent}.
 *
 * @author Lukasz Frankowski
 */
public class EQLRangeQuery<T> extends EQLNode {

	@SerializedName("gte")
	protected T gte;

	@SerializedName("gt")
	protected T gt;

	@SerializedName("lte")
	protected T lte;

	@SerializedName("lt")
	protected T lt;

	@SerializedName("boost")
	protected double boost = 1.0;

	public T getGte() {
		return gte;
	}

	public void setGte(T gte) {
		this.gte = gte;
	}

	public EQLRangeQuery<T> withGte(T gte) {
		setGte(gte);
		return this;
	}

	public T getGt() {
		return gt;
	}

	public void setGt(T gt) {
		this.gt = gt;
	}

	public EQLRangeQuery<T> withGt(T gt) {
		setGt(gt);
		return this;
	}

	public T getLte() {
		return lte;
	}

	public void setLte(T lte) {
		this.lte = lte;
	}

	public EQLRangeQuery<T> withLte(T lte) {
		setLte(lte);
		return this;
	}

	public T getLt() {
		return lt;
	}

	public void setLt(T lt) {
		this.lt = lt;
	}

	public EQLRangeQuery<T> withLt(T lt) {
		setLt(lt);
		return this;
	}

	public double getBoost() {
		return boost;
	}

	public void setBoost(double boost) {
		this.boost = boost;
	}

	public EQLRangeQuery<T> withBoost(double boost) {
		setBoost(boost);
		return this;
	}

	public static <T> EQLRangeQuery<T> of(Class<T> type) {
		return new EQLRangeQuery<>();
	}

}
