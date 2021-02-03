package com.example.takehometest.controller;

import com.example.takehometest.common.Coordinates;
import com.example.takehometest.common.Distance;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.io.File;
import java.io.IOException;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = {"customer.file.location=file:src/test/resources/test-customers.txt", "output.filename=test-output.txt"})
class InviteesControllerTest {

    @Autowired
    private InviteesController controller;

    @Test
    void getInvitees() throws IOException {
        File generatedOutput = controller.getInvitees(new Coordinates(53.339428, -6.257664), new Distance(100.00));
        File expectedOutput = new File("src/test/resources/expected-output.txt");

        Assertions.assertTrue(generatedOutput.exists());
        Assertions.assertTrue(FileUtils.contentEquals(expectedOutput, generatedOutput));
        generatedOutput.deleteOnExit();
    }
}