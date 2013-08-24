package com.artemis.utils;

import java.util.Iterator;

public interface ImmutableBag<E> extends Iterable<E> {
	boolean contains(E e);

	E get(int index);

	boolean isEmpty();

	@Override
	Iterator<E> iterator();

	int size();
}
