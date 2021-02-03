package com.example.takehometest.utility;

import com.example.takehometest.entity.PrintableObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class FilePrinter {
    public void writeIntoFile(final List<PrintableObject> items, final File outputFile) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            items.forEach(item ->
            {
                printWriter.println(item.toString());
            });
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Unable to write into file " + outputFile.getName());
        }

    }
}
