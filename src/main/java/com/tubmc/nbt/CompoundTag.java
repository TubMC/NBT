package com.tubmc.nbt;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.jetbrains.annotations.NotNull;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public sealed class CompoundTag implements ITag<Map<String, ITag<?>>>, Iterable<ITag<?>> permits RootCompoundTag {
	
	private final @NotNull Map<String, ITag<?>> map = new ConcurrentHashMap<String, ITag<?>>();
	
	public final void put(@NotNull @DisallowsEmptyString final String key, @NotNull final ITag<?> tagToAdd) {
		this.map.put(key, tagToAdd);
	}
	
	public final ITag<?> get(@NotNull @DisallowsEmptyString final String key) {
		return this.map.get(key);
	}
	
	public final void remove(final @NotNull @DisallowsEmptyString String key) {
		this.map.remove(key);
	}
	
	public final void clear() {
		this.map.clear();
	}
	
	public final @NotNull Collection<String> getKeys() {
		return this.map.keySet();
	}
	
	@Override
	public Iterator<ITag<?>> iterator() {
		return this.map.values().iterator();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(@NotNull final Map<String, ITag<?>> newValue) {
		this.map.clear();
		this.map.putAll(newValue);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull Map<String, ITag<?>> getValue() {
		return this.map;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull CompoundTag clone() {
		final CompoundTag newTag = new CompoundTag();
		for (final Entry<String, ITag<?>> entry : this.map.entrySet()) {
			newTag.put(entry.getKey(), entry.getValue().clone());
		}
		return newTag;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final byte getTagId() {
		return 10;
	}
}