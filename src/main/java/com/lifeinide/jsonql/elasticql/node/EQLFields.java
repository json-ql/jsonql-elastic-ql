package com.lifeinide.jsonql.elasticql.node;

import javax.annotation.Nonnull;
import java.util.LinkedHashMap;

/**
 * @author Lukasz Frankowski
 */
public class EQLFields<E> extends LinkedHashMap<String, E> {

	public EQLFields<E> withField(@Nonnull String key, @Nonnull E value) {
		put(key, value);
		return this;
	}

}
