package com.lifeinide.jsonql.elasticql.node;

import java.util.LinkedHashMap;

/**
 * @author Lukasz Frankowski
 */
public class EQLFields<E> extends LinkedHashMap<String, E> {

	public EQLFields<E> withField(String key, E value) {
		put(key, value);
		return this;
	}

}
