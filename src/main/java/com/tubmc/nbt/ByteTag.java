package com.tubmc.nbt;

import org.jetbrains.annotations.NotNull;

public final class ByteTag extends AbstractValueTag<Byte> {
	
	public ByteTag(final byte value) {
		super(value);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 1;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull ByteTag clone() {
		return new ByteTag(this.value);
	}
}