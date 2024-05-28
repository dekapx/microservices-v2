package com.dekapx.java.challenges.common;

import java.util.Arrays;
import java.util.EnumSet;

public enum FileWriterType {
    CSV ("csv"),
    JSON ("json"),
    TEXT ("txt"),
    XML ("xml");

    private String fileExtension;
    FileWriterType(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public static boolean isValidFileWriterType(String fileWriterType) {
         EnumSet<FileWriterType> fileWriterTypes = EnumSet.allOf(FileWriterType.class);
         return fileWriterTypes
                 .stream()
                 .anyMatch(o -> o.name().equals(fileWriterType));
    }

    public static boolean isValidFileExtension(String fileExtension) {
        EnumSet<FileWriterType> fileWriterTypes = EnumSet.allOf(FileWriterType.class);
        return fileWriterTypes
                .stream()
                .anyMatch(o -> o.getFileExtension().equals(fileExtension));
    }

    public static FileWriterType getFileWriterTypeByExtension(String fileExtension) {
        return Arrays.stream(FileWriterType.values())
                .filter(i -> i.getFileExtension().equals(fileExtension))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid file extension"));
    }
}
