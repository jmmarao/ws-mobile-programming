package br.edu.ifsp.views;

public class Person {
    private String name;
    private String lastName;
    private String email;
    private String maritalStatus;
    private String gender;

    public Person() {
    }

    public Person(String name, String lastName, String email, String maritalStatus, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
