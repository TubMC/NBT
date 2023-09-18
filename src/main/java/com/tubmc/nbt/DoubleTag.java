package com.tubmc.nbt;

import org.jetbrains.annotations.NotNull;

public final class DoubleTag extends AbstractValueTag<Double> {
	
	public DoubleTag(final double value) {
		super(value);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 6;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull DoubleTag clone() {
		return new DoubleTag(this.value);
	}
}