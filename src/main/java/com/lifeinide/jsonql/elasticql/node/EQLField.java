package com.lifeinide.jsonql.elasticql.node;

/**
 * @author Lukasz Frankowski
 */
public class EQLField<E> extends EQLFields<E> {

	@Override
	public E put(String key, E value) {
		E result =  super.put(key, value);

		if (size()>1)
			throw new IllegalArgumentException("This field component accepts only one field");

		return result;
	}

	@Override
	public EQLField<E> withField(String key, E value) {
		return (EQLField<E>) super.withField(key, value);
	}

	public static <E> EQLField<E> of(String field, E value) {
		return new EQLField<E>().withField(field, value);
	}


}
