package com.tubmc.nbt;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import fun.bb1.objects.defineables.IImmutable;
import fun.bb1.objects.exceptions.ImmutableModificationException;

@Internal
final class EndTag implements ITag<Void>, IImmutable {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setValue(@NotNull final Void newValue) {
		throw new ImmutableModificationException("EndTag's cannot be modified!", this);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull Void getValue() {
		return null;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 0;
	}
	/**
	 * {@inheritDoc}
	 */
	public final @NotNull EndTag clone() {
		return this;
	}
}