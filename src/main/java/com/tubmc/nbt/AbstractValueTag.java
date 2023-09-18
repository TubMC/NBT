package com.tubmc.nbt;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
abstract sealed class AbstractValueTag<T> implements ITag<T> permits ByteTag, ShortTag, IntTag, LongTag, FloatTag, DoubleTag, StringTag {
	
	protected transient T value;
	
	protected AbstractValueTag(@NotNull final T value) {
		this.value = value;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setValue(@NotNull final T newValue) {
		this.value = newValue;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull T getValue() {
		return this.value;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract AbstractValueTag<T> clone();
}