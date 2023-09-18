package com.tubmc.nbt;

import java.util.ArrayList;
import java.util.Collections;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

@Internal
abstract sealed class AbstractValueArrayTag<T> implements ITag<T[]> permits ByteArrayTag, IntArrayTag, LongArrayTag {
	
	protected transient ArrayList<T> array = new ArrayList<T>();
	
	protected AbstractValueArrayTag() { }
	
	public final void add(@NotNull final T newElement) {
		this.array.add(newElement);
	}
	
	public final @NotNull T add(final int index) {
		return this.array.get(index);
	}
	
	public final int getSize() {
		return this.array.size();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setValue(@NotNull final T[] newValue) {
		this.array.clear();
		Collections.addAll(this.array, newValue);
	}
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final @NotNull T[] getValue() {
		return (T[]) this.array.toArray();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract AbstractValueArrayTag<T> clone();
}