package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileU {
    public static byte[] readByte (String filename) throws IOException {
        Path filePath = Paths.get(filename);
        byte[] byteArray = Files.readAllBytes(filePath);
        return byteArray;
    }


}
