package com.tubmc.nbt;

import org.jetbrains.annotations.NotNull;

public final class FloatTag extends AbstractValueTag<Float> {
	
	public FloatTag(final float value) {
		super(value);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 5;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull FloatTag clone() {
		return new FloatTag(this.value);
	}
}