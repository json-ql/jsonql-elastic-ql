package com.lifeinide.jsonql.elasticql.node;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLComponent;

/**
 * Root object for ElasticSearch query.
 *
 * @author Lukasz Frankowski
 */
public class EQLRoot extends EQLNode {

	@SerializedName("query")
	protected EQLComponent query;

	@SerializedName("sort")
	protected EQLFields<EQLSort> sort;

	@SerializedName("highlight")
	protected EQLHighlight highlight;

	public EQLComponent getQuery() {
		return query;
	}

	public void setQuery(EQLComponent query) {
		this.query = query;
	}

	public EQLRoot withQuery(EQLComponent query) {
		setQuery(query);
		return this;
	}

	public EQLFields<EQLSort> getSort() {
		if (sort==null)
			sort = new EQLFields<>();

		return sort;
	}

	public void setSort(EQLFields<EQLSort> sort) {
		this.sort = sort;
	}

	public EQLRoot withSort(String field, EQLSort sort) {
		getSort().put(field, sort);
		return this;
	}

	public EQLHighlight getHighlight() {
		return highlight;
	}

	public void setHighlight(EQLHighlight highlight) {
		this.highlight = highlight;
	}

	public EQLRoot withHighlight(EQLHighlight highlight) {
		setHighlight(highlight);
		return this;
	}

	public static EQLRoot of() {
		return new EQLRoot();
	}

}
