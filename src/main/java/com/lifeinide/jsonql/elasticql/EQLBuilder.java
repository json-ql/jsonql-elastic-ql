package com.lifeinide.jsonql.elasticql;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.lifeinide.jsonql.elasticql.node.EQLRoot;

/**
 * @author Lukasz Frankowski
 */
public class EQLBuilder {

	protected Gson gson;

	public EQLBuilder() {
		this.gson = new GsonBuilder()
			.setPrettyPrinting()
			.create();
	}

	public JsonElement toJson(EQLRoot root) {
		return gson.toJsonTree(root);
	}

	public String toJsonString(EQLRoot root) {
		return gson.toJson(toJson(root));
	}

}
