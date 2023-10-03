package com.tubmc.nbt.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import com.tubmc.nbt.ByteArrayTag;
import com.tubmc.nbt.ByteTag;
import com.tubmc.nbt.CompoundTag;
import com.tubmc.nbt.DoubleTag;
import com.tubmc.nbt.FloatTag;
import com.tubmc.nbt.ITag;
import com.tubmc.nbt.IntArrayTag;
import com.tubmc.nbt.IntTag;
import com.tubmc.nbt.ListTag;
import com.tubmc.nbt.LongArrayTag;
import com.tubmc.nbt.LongTag;
import com.tubmc.nbt.RootCompoundTag;
import com.tubmc.nbt.ShortTag;
import com.tubmc.nbt.StringTag;

import fun.bb1.objects.defineables.IStaticMethodsOnly;

@Internal
final class NBTWriter implements IStaticMethodsOnly {
	
	@Internal
	static final void write(@NotNull final File file, @NotNull final CompoundTag toWrite) throws IOException {
		write(new FileOutputStream(file), toWrite);
	}
	
	@Internal
	static final void write(@NotNull final OutputStream providedOutputStream, @NotNull final CompoundTag toWrite) throws IOException {
		final DataOutputStream outputStream = new DataOutputStream(providedOutputStream);
		outputStream.writeByte(10);
		if (toWrite instanceof RootCompoundTag root) {
			outputStream.writeUTF(root.getName());
		} else {
			outputStream.writeUTF("");
		}
		writeCompoundTag(toWrite, outputStream);
		outputStream.close();
	}
	
	private static final void writeCompoundTag(@NotNull final CompoundTag baseUpon, @NotNull final DataOutputStream outputStream) throws IOException {
		for (final String key : baseUpon.getKeys()) {
			final ITag<?> tag = baseUpon.get(key);
			outputStream.writeByte(tag.getTagId());
			outputStream.writeUTF(key);
			writeTag(tag, outputStream);
		}
		outputStream.writeByte(0);
	}
	
	private static final void writeListTag(@NotNull final ListTag<?> listTag, @NotNull final DataOutputStream outputStream) throws IOException {
		outputStream.writeByte(listTag.getTypeTagId());
		outputStream.writeInt(listTag.size());
		for (final ITag<?> tag : listTag) {
			writeTag(tag, outputStream);
		}
	}
	
	private static final void writeTag(final @NotNull ITag<?> tag, @NotNull final DataOutputStream outputStream) throws IOException {
		if (tag instanceof final ByteTag byteTag) {
			outputStream.writeByte(byteTag.getValue());
		} else if (tag instanceof final ShortTag shortTag) {
			outputStream.writeShort(shortTag.getValue());
		} else if (tag instanceof final IntTag intTag) {
			outputStream.writeInt(intTag.getValue());
		} else if (tag instanceof final LongTag longTag) {
			outputStream.writeLong(longTag.getValue());
		} else if (tag instanceof final FloatTag floatTag) {
			outputStream.writeFloat(floatTag.getValue());
		} else if (tag instanceof final DoubleTag doubleTag) {
			outputStream.writeDouble(doubleTag.getValue());
		} else if (tag instanceof final ByteArrayTag byteArrayTag) {
			outputStream.writeInt(byteArrayTag.getSize());
			for (final Byte byt : byteArrayTag.getValue()) {
				outputStream.writeByte(byt.byteValue());
			}
		} else if (tag instanceof final StringTag stringTag) {
			outputStream.writeUTF(stringTag.getValue());
		} else if (tag instanceof final ListTag<?> listTag) {
			writeListTag(listTag, outputStream);
		} else if (tag instanceof final CompoundTag compundTag) {
			writeCompoundTag(compundTag, outputStream);
		} else if (tag instanceof final IntArrayTag intArrayTag) {
			outputStream.writeInt(intArrayTag.getSize());
			for (final Integer in : intArrayTag.getValue()) {
				outputStream.writeInt(in.intValue());
			}
		} else if (tag instanceof final LongArrayTag longArrayTag) {
			outputStream.writeInt(longArrayTag.getSize());
			for (final Long lon : longArrayTag.getValue()) {
				outputStream.writeLong(lon.longValue());
			}
		} else {
			throw new IllegalArgumentException("No tag with name " + tag.getClass().getName());
		}
	}
	
	private NBTWriter() { }
}