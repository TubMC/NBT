package com.tubmc.nbt;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ListTag<T extends ITag<?>> implements ITag<List<T>>, Iterable<T> {
	
	private final @NotNull List<T> list = new CopyOnWriteArrayList<T>();
	private final byte typeTagId;
	
	public ListTag(final byte typeTagId) {
		this.typeTagId = typeTagId;
	}
	
	public ListTag(@NotNull final Collection<T> tags) {
		if (tags.isEmpty()) throw new IllegalArgumentException("ListTag constructor Collection must not be null!");
		this.typeTagId = tags.stream().findAny().get().getTagId();
		this.list.addAll(tags);
	}
	
	public final void add(@NotNull final T tagToAdd) {
		this.list.add(tagToAdd);
	}
	
	public final @Nullable T get(final int index) {
		return this.list.get(index);
	}
	
	public final byte getTypeTagId() {
		return this.typeTagId;
	}
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setValue(@NotNull final List<T> newValue) {
		this.list.clear();
		for (final T tag : newValue) {
			this.list.add((T) tag.clone());
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull List<T> getValue() {
		return this.list;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull ListTag<T> clone() {
		final ListTag<T> newTag = new ListTag<T>(this.getTypeTagId());
		for (final T tag : this.list) {
			newTag.add(tag);
		}
		return newTag;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte getTagId() {
		return 9;
	}
	
	@Override
	public final @NotNull Iterator<T> iterator() {
		return this.list.iterator();
	}
}