package com.tubmc.nbt;

import java.util.Collection;

import org.jetbrains.annotations.NotNull;

public final class LongArrayTag extends AbstractValueArrayTag<Long> {
	
	public LongArrayTag() {
		super(Long.class);
	}
	
	public LongArrayTag(@NotNull final long[] array) {
		super(Long.class);
		this.array.clear();
		for (final long lon : array) {
			this.array.add(lon);
		}
	}
	
	public LongArrayTag(@NotNull final Collection<Long> collection) {
		super(Long.class);
		this.array.clear();
		this.array.addAll(collection);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 11;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull LongArrayTag clone() {
		return new LongArrayTag(this.array);
	}
}