package com.tubmc.nbt;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public final class RootCompoundTag extends CompoundTag {
	
	private final @DisallowsEmptyString @NotNull String name;
	
	@Internal
	public RootCompoundTag(final @DisallowsEmptyString @NotNull String name) {
		this.name = name;
	}
	
	public final @DisallowsEmptyString @NotNull String getName() {
		return this.name;
	}
}
