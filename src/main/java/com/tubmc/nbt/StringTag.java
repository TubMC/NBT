package com.tubmc.nbt;

import org.jetbrains.annotations.NotNull;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public final class StringTag extends AbstractValueTag<String> {
	
	public StringTag(@NotNull @DisallowsEmptyString final String value) {
		super(value);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 8;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull StringTag clone() {
		return new StringTag(this.value);
	}
}