package com.tiger.designPatterns200.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileManagerTest {

    @Test
    void testFileToString() {
        FileManager fileManager = new FileManager();
        String string = "Hello, World! This is a test file content.";
        try {
            File tempFile = File.createTempFile("testFile", ".txt");
            FileWriter writer = new FileWriter(tempFile);
            writer.write(string);
            writer.close();
            
            String result = fileManager.streamToString(new FileInputStream(tempFile));

            assertEquals(string, result);
        } catch (IOException e) {
            fail("Failed to create temporary test file.");
        }
    }
}
