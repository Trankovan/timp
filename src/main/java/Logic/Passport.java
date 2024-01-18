package Logic;

import java.util.Date;

public class Passport {
    private String firstName;
    private String lastName;
    private String middleName;
    private String seriesNumber;
    private Date dateOfBirth;
    private Date issueDate;
    private String address;
    private String maritalStatus;

    public Passport(String firstName, String lastName, String middleName, String seriesNumber,
                    Date dateOfBirth, Date issueDate, String address, String maritalStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.seriesNumber = seriesNumber;
        this.dateOfBirth = dateOfBirth;
        this.issueDate = issueDate;
        this.address = address;
        this.maritalStatus = maritalStatus;
    }

    public Passport(String part, String part1, String part2, String part3, String part4, String part5, String part6, String part7) {
    }

    // Геттеры и сеттеры для всех атрибутов

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Дополнительные методы, если необходимо

    @Override
    public String toString() {
        return "Passport{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", seriesNumber='" + seriesNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", issueDate=" + issueDate +
                ", address='" + address + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                '}';
    }

    public Object getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }
}
