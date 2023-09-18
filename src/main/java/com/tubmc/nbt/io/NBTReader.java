package com.tubmc.nbt.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

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
final class NBTReader implements IStaticMethodsOnly {
	
	@Internal
	static final @NotNull CompoundTag read(@NotNull final File file) throws IOException {
		final BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
		bufferedInputStream.mark(0);
		final int firstBit = bufferedInputStream.read();
		bufferedInputStream.reset();
		return read(switch (firstBit) {
			case 120 -> new InflaterInputStream(bufferedInputStream);
			case 31 -> new GZIPInputStream(bufferedInputStream);
			default -> bufferedInputStream;
		});
	}
	
	@Internal
	static final @NotNull CompoundTag read(@NotNull final InputStream providedInputStream) throws IOException {
		final DataInputStream inputStream = new DataInputStream(providedInputStream);
		final int rootType = inputStream.readByte();
		if (rootType != 10) {
			throw new IllegalArgumentException("Root tag must be a compound tag!");
		}
		final CompoundTag compoundTag = new RootCompoundTag(inputStream.readUTF());
		readCompoundTag(compoundTag, inputStream);
		inputStream.close();
		return compoundTag;
	}
	
	private static final void readCompoundTag(@NotNull final CompoundTag baseUpon, @NotNull final DataInputStream inputStream) throws IOException {
		byte type;
		do {
			type = inputStream.readByte();
			if (type == 0) break; // hit end tag
			baseUpon.put(inputStream.readUTF(), readTag(type, inputStream));
		} while (true);
	}
	
	@SuppressWarnings("unchecked")
	private static final <T extends ITag<?>> ListTag<T> readListTag(@NotNull final DataInputStream inputStream) throws IOException {
		final ListTag<T> listTag = new ListTag<T>(inputStream.readByte());
		final int length = inputStream.readInt();
		for (int i = 0; i < length; i++) {
			listTag.add((T) readTag(listTag.getTypeTagId(), inputStream));
		}
		return listTag;
	}
	
	private static final @NotNull ITag<?> readTag(final byte id, @NotNull final DataInputStream inputStream) throws IOException {
		return switch (id) {
			case 0 -> null;
			case 1 -> new ByteTag(inputStream.readByte());
			case 2 -> new ShortTag(inputStream.readShort());
			case 3 -> new IntTag(inputStream.readInt());
			case 4 -> new LongTag(inputStream.readLong());
			case 5 -> new FloatTag(inputStream.readFloat());
			case 6 -> new DoubleTag(inputStream.readDouble());
			case 7 -> {
				final byte[] array = new byte[inputStream.readInt()];
				inputStream.readFully(array);
				yield new ByteArrayTag(array);
			}
			case 8 -> new StringTag(inputStream.readUTF());
			case 9 -> readListTag(inputStream);
			case 10 -> {
				final CompoundTag compoundTag = new CompoundTag();
				readCompoundTag(compoundTag, inputStream);
				yield compoundTag;
			}
			case 11 -> {
				final int[] array = new int[inputStream.readInt()];
				for (int i = 0 ; i < array.length; i++) {
					array[i] = inputStream.readInt();
				}
				yield new IntArrayTag(array);
			}
			case 12 -> {
				final long[] array = new long[inputStream.readInt()];
				for (int i = 0 ; i < array.length; i++) {
					array[i] = inputStream.readLong();
				}
				yield new LongArrayTag(array);
			}
			default -> throw new IllegalArgumentException("No tag with id " + id);
		};
	}
	
	private NBTReader() { }
}