package com.example.takehometest.utility;

import com.example.takehometest.entity.PrintableObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

class FilePrinterTest {
    private FilePrinter unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = new FilePrinter();
    }

    @Test
    void writeIntoFile(@TempDir File temporaryDirectory) throws IOException {
        File temporaryFile = new File(temporaryDirectory, "test.txt");
        String testCustomerString = "Customer name: Margaret Smith, id: 123";

        PrintableObject printable = new PrintableObject() {
            @Override
            public String toString() {
                return testCustomerString;
            }
        };

        unitUnderTest.writeIntoFile(Collections.singletonList(printable), temporaryFile);

        Assertions.assertTrue(Files.exists(temporaryFile.toPath()));
        Assertions.assertEquals(Collections.singletonList(testCustomerString), Files.readAllLines(temporaryFile.toPath()));
    }
}