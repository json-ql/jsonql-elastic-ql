package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.EQLNode;
import com.lifeinide.jsonql.elasticql.node.component.EQLRangeComponent;

import javax.annotation.Nonnull;

/**
 * A query for {@link EQLRangeComponent}.
 *
 * @author Lukasz Frankowski
 */
public class EQLRangeQuery<T> extends EQLNode {

	@SerializedName("gte")
	protected T gte = null;

	@SerializedName("gt")
	protected T gt = null;

	@SerializedName("lte")
	protected T lte = null;

	@SerializedName("lt")
	protected T lt = null;

	@SerializedName("boost")
	protected double boost = 1.0;

	public T getGte() {
		return gte;
	}

	public void setGte(T gte) {
		this.gte = gte;
	}

	@Nonnull public EQLRangeQuery<T> withGte(@Nonnull T gte) {
		setGte(gte);
		return this;
	}

	public T getGt() {
		return gt;
	}

	public void setGt(T gt) {
		this.gt = gt;
	}

	@Nonnull public EQLRangeQuery<T> withGt(@Nonnull T gt) {
		setGt(gt);
		return this;
	}

	public T getLte() {
		return lte;
	}

	public void setLte(T lte) {
		this.lte = lte;
	}

	@Nonnull public EQLRangeQuery<T> withLte(@Nonnull T lte) {
		setLte(lte);
		return this;
	}

	public T getLt() {
		return lt;
	}

	public void setLt(T lt) {
		this.lt = lt;
	}

	@Nonnull public EQLRangeQuery<T> withLt(@Nonnull T lt) {
		setLt(lt);
		return this;
	}

	public double getBoost() {
		return boost;
	}

	public void setBoost(double boost) {
		this.boost = boost;
	}

	@Nonnull public EQLRangeQuery<T> withBoost(double boost) {
		setBoost(boost);
		return this;
	}

	@Nonnull public static <T> EQLRangeQuery<T> ofGte(@Nonnull T value) {
		return new EQLRangeQuery<T>().withGte(value);
	}

	@Nonnull public static <T> EQLRangeQuery<T> ofGt(@Nonnull T value) {
		return new EQLRangeQuery<T>().withGt(value);
	}

	@Nonnull public static <T> EQLRangeQuery<T> ofLte(@Nonnull T value) {
		return new EQLRangeQuery<T>().withLte(value);
	}

	@Nonnull public static <T> EQLRangeQuery<T> ofLt(@Nonnull T value) {
		return new EQLRangeQuery<T>().withLt(value);
	}

}
