package com.tubmc.nbt;

import java.util.Collection;

import org.jetbrains.annotations.NotNull;

public final class IntArrayTag extends AbstractValueArrayTag<Integer> {
	
	public IntArrayTag() {
		super(Integer.class);
	}
	
	public IntArrayTag(@NotNull final int[] array) {
		super(Integer.class);
		this.array.clear();
		for (final int in : array) {
			this.array.add(in);
		}
	}
	
	public IntArrayTag(@NotNull final Collection<Integer> collection) {
		super(Integer.class);
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
	public final @NotNull IntArrayTag clone() {
		return new IntArrayTag(this.array);
	}
}