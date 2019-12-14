package com.lifeinide.jsonql.elasticql;

import com.google.gson.*;
import com.lifeinide.jsonql.elasticql.node.EQLNode;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Serializes {@link EQLNode}-s into JSON.
 *
 * @author Lukasz Frankowski
 */
public class EQLBuilder {

	public static final String DATE_FORMAT = "yyyy-MM-dd";

	protected Gson gson;

	public EQLBuilder() {
		this.gson = new GsonBuilder()
			.setPrettyPrinting()
			.setDateFormat(DATE_FORMAT) // for java.util.Date
			.registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>) (src, typeOfSrc, context) ->
				new JsonPrimitive(src.format(DateTimeFormatter.ofPattern(DATE_FORMAT)))) // for java.time.LocalDate
			.create();
	}

	@Nonnull public JsonObject toJson(@Nonnull EQLNode root) {
		return (JsonObject) gson.toJsonTree(root);
	}

	@Nonnull public String toJsonString(@Nonnull EQLNode root) {
		return gson.toJson(toJson(root));
	}

}
