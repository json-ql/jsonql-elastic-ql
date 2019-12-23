package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLBoolComponent;
import com.lifeinide.jsonql.elasticql.node.component.EQLComponent;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * A query for {@link EQLBoolComponent}.
 *
 * @author Lukasz Frankowski
 */
public class EQLBool {

	@SerializedName("must") protected List<EQLComponent> must;
	@SerializedName("must_not") protected List<EQLComponent> mustNot;
	@SerializedName("should") protected List<EQLComponent> should;
	@SerializedName("filter") protected List<EQLComponent> filter;

	@Nonnull public List<EQLComponent> getMust() {
		if (must==null)
			must = new ArrayList<>();

		return must;
	}

	public void setMust(List<EQLComponent> must) {
		this.must = must;
	}

	/**
	 * Adds a new "must" query, i.e. query with "and" conjunction.
	 */
	@Nonnull public EQLBool withMust(@Nonnull EQLComponent must) {
		getMust().add(must);
		return this;
	}

	@Nonnull public List<EQLComponent> getMustNot() {
		if (mustNot==null)
			mustNot = new ArrayList<>();

		return mustNot;
	}

	public void setMustNot(List<EQLComponent> mustNot) {
		this.mustNot = mustNot;
	}

	@Nonnull public EQLBool withMustNot(@Nonnull EQLComponent mustNot) {
		getMustNot().add(mustNot);
		return this;
	}

	@Nonnull public List<EQLComponent> getShould() {
		if (should==null)
			should = new ArrayList<>();

		return should;
	}

	public void setShould(List<EQLComponent> should) {
		this.should = should;
	}

	/**
	 * Adds a new "should" query, i.e. query with "or" conjunction.
	 */
	@Nonnull public EQLBool withShould(@Nonnull EQLComponent should) {
		getShould().add(should);
		return this;
	}

	@Nonnull public List<EQLComponent> getFilter() {
		if (filter==null)
			filter = new ArrayList<>();

		return filter;
	}

	public void setFilter(List<EQLComponent> filter) {
		this.filter = filter;
	}

	public boolean isEmpty() {
		return must==null && mustNot==null && should==null && filter==null;
	}

	/**
	 * Adds another filter expression with "and" conjunction. To add filters with "or" you need to add new {@link EQLBool} here
	 * and use its {@link EQLBool#withShould(EQLComponent)} method.
	 */
	@Nonnull public EQLBool withFilter(@Nonnull EQLComponent filter) {
		getFilter().add(filter);
		return this;
	}

	@Nonnull public static EQLBool of() {
		return new EQLBool();
	}

}
