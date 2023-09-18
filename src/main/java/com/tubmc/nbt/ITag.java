package com.tubmc.nbt;

import org.jetbrains.annotations.NotNull;

import fun.bb1.objects.defineables.ITypedProxy;

public sealed interface ITag<T> extends Cloneable, ITypedProxy<T> permits CompoundTag, EndTag, AbstractValueTag<T>, AbstractValueArrayTag<T>, ListTag<ITag<T>> {
	
	public void setValue(@NotNull final T newValue);
	
	public @NotNull T getValue();
	
	public @NotNull ITag<T> clone();
	/**
	 * {@inheritDoc}
	 */
	@Override
	default @NotNull T getProxiedObject() {
		return this.getValue();
	}
	
	public byte getTagId();
}
