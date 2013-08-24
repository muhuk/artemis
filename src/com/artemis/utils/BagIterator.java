package com.artemis.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BagIterator<E> implements Iterator<E> {
	private final Bag<E>	bag;
	private final int		size;
	private int				currentIndex;

	public BagIterator(Bag<E> bag) {
		this.bag = bag;
		currentIndex = 0;
		this.size = bag.size();
	}

	@Override
	public boolean hasNext() {
		return currentIndex < size;
	}

	@Override
	public E next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return bag.get(currentIndex++);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("You cannot remove items from an ImmutableBag.");
	}
}
