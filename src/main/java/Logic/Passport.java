package Logic;

import java.util.Date;
import java.util.Objects;

public class Passport {
    private String firstName;
    private String lastName;
    private String middleName;
    private String seriesNumber;
    private String dateOfBirth;
    private String issueDate;
    private String address;
    private String maritalStatus;
    private String sex;

    public Passport(String firstName, String lastName, String middleName, String seriesNumber,
                    String dateOfBirth, String issueDate, String address, String maritalStatus,String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.seriesNumber = seriesNumber;
        this.dateOfBirth = dateOfBirth;
        this.issueDate = issueDate;
        this.address = address;
        this.maritalStatus = maritalStatus;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getAddress() {
        return address;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }
// Дополнительные методы, если необходимо

    @Override
    public String toString() {
        return lastName+" "+firstName+" "+middleName+" "+seriesNumber+" "+dateOfBirth+" "+issueDate+" "+address+
                " "+maritalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(firstName, passport.firstName) && Objects.equals(lastName, passport.lastName) && Objects.equals(middleName, passport.middleName) && Objects.equals(seriesNumber, passport.seriesNumber) && Objects.equals(dateOfBirth, passport.dateOfBirth) && Objects.equals(issueDate, passport.issueDate) && Objects.equals(address, passport.address) && Objects.equals(maritalStatus, passport.maritalStatus) && Objects.equals(sex, passport.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, seriesNumber, dateOfBirth, issueDate, address, maritalStatus, sex);
    }
}
