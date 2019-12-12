package com.lifeinide.jsonql.elasticql.node.query;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code bool} query component.
 *
 * @author Lukasz Frankowski
 */
public class EQLBool {

	@SerializedName("must") protected List<EQLComponent> must;
	@SerializedName("should") protected List<EQLComponent> should;
	@SerializedName("filter") protected List<EQLComponent> filter;

	public List<EQLComponent> getMust() {
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
	public EQLBool withMust(EQLComponent must) {
		getMust().add(must);
		return this;
	}

	public List<EQLComponent> getShould() {
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
	public EQLBool withShould(EQLComponent should) {
		getShould().add(should);
		return this;
	}

	public List<EQLComponent> getFilter() {
		if (filter==null)
			filter = new ArrayList<>();

		return filter;
	}

	public void setFilter(List<EQLComponent> filter) {
		this.filter = filter;
	}

	/**
	 * Adds another filter expression with "and" conjunction. To add filters with "or" you need to add new {@link EQLBool} here
	 * and use its {@link EQLBool#withShould(EQLComponent)} method.
	 */
	public EQLBool withFilter(EQLComponent filter) {
		getFilter().add(filter);
		return this;
	}

}
