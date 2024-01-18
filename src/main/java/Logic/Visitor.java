package Logic;

import java.util.Date;

public class Visitor {
    private String fullName;
    private Passport passport;
    private Visa visa;

    public Visitor(String fullName, Passport passport, Visa visa) {
        this.fullName = fullName;
        this.passport = passport;
        this.visa = visa;
    }

    // Геттеры и сеттеры для всех атрибутов

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }


}
