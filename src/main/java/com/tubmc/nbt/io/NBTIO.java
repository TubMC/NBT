package com.tubmc.nbt.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.jetbrains.annotations.NotNull;

import com.tubmc.nbt.CompoundTag;

import fun.bb1.objects.defineables.IStaticMethodsOnly;

public final class NBTIO implements IStaticMethodsOnly {
	
	public static final @NotNull CompoundTag readFromFile(@NotNull final File file) throws IOException {
		return NBTReader.read(file);
	}
	
	public static final @NotNull CompoundTag readFromStream(@NotNull final InputStream inputStream) throws IOException {
		return NBTReader.read(inputStream);
	}
	
	public static final void writeToFile(@NotNull final File file, final @NotNull CompoundTag compoundTag) throws IOException {
		NBTWriter.write(file, compoundTag);
	}
	
	public static final void writeToStream(@NotNull final OutputStream outputStream, final @NotNull CompoundTag compoundTag) throws IOException {
		NBTWriter.write(outputStream, compoundTag);
	}
	
	private NBTIO() { }
	
}
