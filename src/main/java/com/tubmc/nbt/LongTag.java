package com.tubmc.nbt;

import org.jetbrains.annotations.NotNull;

public final class LongTag extends AbstractValueTag<Long> {
	
	public LongTag(final long value) {
		super(value);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 4;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull LongTag clone() {
		return new LongTag(this.value);
	}
}