package com.example.takehometest.request;

import com.example.takehometest.common.Coordinates;
import com.example.takehometest.common.Distance;
import com.example.takehometest.controller.InviteesController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Scanner;

@Component
@Profile("!test")
@RequiredArgsConstructor
public class InviteesRequest implements CommandLineRunner {

    private final InviteesController inviteesController;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide origin latitude");
        String latitude = scanner.next();
        System.out.println("Please provide origin longitude");
        String longitude = scanner.next();
        System.out.println("Please provide invitee distance");
        String distanceString = scanner.next();
        scanner.close();

        Coordinates origin = new Coordinates(latitude, longitude);

        Distance distance = new Distance( Double.parseDouble( distanceString ) );

        File file = inviteesController.getInvitees(origin, distance);

        System.out.print("Invitees list at " + file.getPath());

        System.exit(0);
    }
}
