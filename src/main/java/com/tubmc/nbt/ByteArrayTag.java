package com.tubmc.nbt;

import java.util.Collection;

import org.jetbrains.annotations.NotNull;

public final class ByteArrayTag extends AbstractValueArrayTag<Byte> {
	
	public ByteArrayTag() { }
	
	public ByteArrayTag(@NotNull final byte[] array) {
		this.array.clear();
		for (final byte byt : array) {
			this.array.add(byt);
		}
	}
	
	public ByteArrayTag(@NotNull final Collection<Byte> collection) {
		this.array.clear();
		this.array.addAll(collection);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 7;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull ByteArrayTag clone() {
		return new ByteArrayTag(this.array);
	}
}