package Logic;

import java.util.Date;

public class InternationalPassport {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dateOfBirth;
    private String issuingCountry;
    private Date issueDate;

    public InternationalPassport(String firstName, String lastName, String middleName,
                                 Date dateOfBirth, String issuingCountry, Date issueDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.issuingCountry = issuingCountry;
        this.issueDate = issueDate;
    }

    public InternationalPassport() {

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
        return "InternationalPassport{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", issuingCountry='" + issuingCountry + '\'' +
                ", issueDate=" + issueDate +
                '}';
    }

    public Object getFullName() {
        return this.firstName +" " + this.lastName;
    }
}
