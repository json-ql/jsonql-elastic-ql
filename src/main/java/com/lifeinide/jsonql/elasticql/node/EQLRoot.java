package com.lifeinide.jsonql.elasticql.node;

import com.google.gson.annotations.SerializedName;
import com.lifeinide.jsonql.elasticql.node.component.EQLComponent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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

	@SerializedName("from")
	protected Integer from;

	@SerializedName("size")
	protected Integer size;

	public EQLComponent getQuery() {
		return query;
	}

	public void setQuery(EQLComponent query) {
		this.query = query;
	}

	@Nonnull public EQLRoot withQuery(@Nonnull EQLComponent query) {
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

	@Nonnull public EQLRoot withSort(@Nonnull String field, @Nonnull EQLSort sort) {
		getSort().put(field, sort);
		return this;
	}

	public EQLHighlight getHighlight() {
		return highlight;
	}

	public void setHighlight(EQLHighlight highlight) {
		this.highlight = highlight;
	}

	@Nonnull public EQLRoot withHighlight(@Nonnull EQLHighlight highlight) {
		setHighlight(highlight);
		return this;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public EQLRoot withPage(@Nullable Integer from, @Nullable Integer size) {
		setFrom(from);
		setSize(size);
		return this;
	}

	@Nonnull public static EQLRoot of() {
		return new EQLRoot();
	}

}
