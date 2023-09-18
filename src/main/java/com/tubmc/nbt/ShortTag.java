package com.tubmc.nbt;

import org.jetbrains.annotations.NotNull;

public final class ShortTag extends AbstractValueTag<Short> {
	
	public ShortTag(final short value) {
		super(value);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 2;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull ShortTag clone() {
		return new ShortTag(this.value);
	}
}