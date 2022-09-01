package br.edu.ifsp.myapplication;

public class User {
    private String name;
    private String email;
    private String phoneType;
    private String phone;
    private String gender;
    private String birthDate;
    private String interestAreas;

    public User(String name, String email, String phoneType, String phone, String gender, String birthDate, String interestAreas) {
        this.name = name;
        this.email = email;
        this.phoneType = phoneType;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
        this.interestAreas = interestAreas;
    }

    @Override
    public String toString() {
        return "Full name: " + name +
                "\n\tEmail: " + email +
                "\n\tPhone type: " + phoneType +
                "\n\t\t" + phone +
                "\n\tGender: " + gender +
                "\n\tBirth date: " + birthDate +
                "\n\tAreas of interest: " + interestAreas +
                "\n---------------------------------------";
    }
}
