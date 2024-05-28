package com.dekapx.java.challenges.basics;

import com.dekapx.java.challenges.common.FileWriterType;

public class FileWriterTypeDemo {
    void main(String[] args) {
        System.out.println(FileWriterType.CSV.name());
        System.out.println(FileWriterType.CSV.getFileExtension());

        System.out.println(FileWriterType.getFileWriterTypeByExtension("csv"));

        System.out.println(FileWriterType.isValidFileWriterType("TEXT"));
        System.out.println(FileWriterType.isValidFileExtension("json"));
    }
}
