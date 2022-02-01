package com.example.youtube2;

public class Member {
    private String firstName;
    private String lastName;
    private boolean available = false;

    public Member(String firstName, String lastName, boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.available = available;
    }

    public boolean isAvailable() {return available;}

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
