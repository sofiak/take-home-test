package com.example.takehometest.entity;

import com.example.takehometest.common.Coordinates;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Comparable<Customer>, PrintableObject {
    @Getter
    @Setter
    @JsonProperty("user_id")
    private long userId;
    @Setter
    @Getter
    private String name;
    @Setter
    private double latitude;
    @Setter
    private double longitude;
    private Coordinates location;

    public Coordinates getLocation() {
        if (location == null) {
            this.location = new Coordinates(latitude, longitude);
        }
        return location;
    }

    @Override
    public int compareTo(Customer otherCustomer) {
        return Long.compare(getUserId(), otherCustomer.getUserId());
    }

    @Override
    public String toString() {
        return String.format("Customer name: %s, id: %s", getName(), getUserId());
    }
}
