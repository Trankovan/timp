package Logic;


import java.util.Date;

public class Visa {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date issueDate;
    private String countries;
    private String visaType;




    public Visa(String firstName, String lastName, String middleName, Date issueDate, String countries, String visaType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.issueDate = issueDate;
        this.countries = countries;
        this.visaType = visaType;
    }

    public Visa() {

    }

    // Геттеры и сеттеры для всех атрибутов

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getVisaType() {
        return visaType;
    }

    // Другие геттеры
}
