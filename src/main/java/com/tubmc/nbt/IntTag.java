package com.tubmc.nbt;

import org.jetbrains.annotations.NotNull;

public final class IntTag extends AbstractValueTag<Integer> {
	
	public IntTag(final int value) {
		super(value);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 3;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull IntTag clone() {
		return new IntTag(this.value);
	}
}