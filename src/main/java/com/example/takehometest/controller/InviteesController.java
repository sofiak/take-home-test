package com.example.takehometest.controller;

import com.example.takehometest.common.Coordinates;
import com.example.takehometest.common.Distance;
import com.example.takehometest.entity.Customer;
import com.example.takehometest.entity.PrintableObject;
import com.example.takehometest.repository.CustomerRepository;
import com.example.takehometest.service.DistanceHelper;
import com.example.takehometest.utility.FilePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class InviteesController {
    private final DistanceHelper distanceHelper;
    private final CustomerRepository customerRepository;
    private final FilePrinter filePrinter;

    @Value("${output.filename}")
    private String fileName;

    public File getInvitees(final Coordinates origin, final Distance distance) {
        List<Customer> customerList = customerRepository.findAll();
        List<PrintableObject> filteredCustomers = customerList.stream()
                .filter(customer -> distanceHelper.withinDistance(origin, customer.getLocation(), distance))
                .sorted()
                .collect(Collectors.toList());

        File output = new File(fileName);

        filePrinter.writeIntoFile(filteredCustomers, output);

        return output;
    }
}
