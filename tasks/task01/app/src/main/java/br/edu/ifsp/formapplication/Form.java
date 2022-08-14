package br.edu.ifsp.formapplication;

public class Form {
    private String name;
    private String phone;
    private String email;
    private boolean isSubscriber;
    private String gender;
    private String city;
    private String fu;

    public Form(String name, String phone, String email, boolean isSubscriber, String gender, String city, String fu) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.isSubscriber = isSubscriber;
        this.gender = gender;
        this.city = city;
        this.fu = fu;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\n\tPhone: " + phone +
                "\n\tEmail: " + email +
                "\n\tSubscriber: " + isSubscriber +
                "\n\tGender: " + gender +
                "\n\tCity: " + city +
                " (" + fu + ")";
    }
}
