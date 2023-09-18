package com.tubmc.nbt;

import java.util.Collection;

import org.jetbrains.annotations.NotNull;

public final class LongArrayTag extends AbstractValueArrayTag<Long> {
	
	public LongArrayTag() { }
	
	public LongArrayTag(@NotNull final long[] array) {
		this.array.clear();
		for (final long lon : array) {
			this.array.add(lon);
		}
	}
	
	public LongArrayTag(@NotNull final Collection<Long> collection) {
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