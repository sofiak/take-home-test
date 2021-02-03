package com.example.takehometest.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class FileReader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public <T> List<T> readLinesFromFile(final URI fileLocation, final Class<T> objectToCreate) {
        List<T> list = new ArrayList<>();
        try {
            URL url = fileLocation.toURL();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                list.add(mapper.readValue(input, objectToCreate));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return list;
    }
}
