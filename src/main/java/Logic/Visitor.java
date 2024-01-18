package Logic;

import java.util.Date;

public class Visitor {
    private String fullName;
    private Passport passport;

    public Visitor(String fullName, Passport passport) {
        this.fullName = fullName;
        this.passport = passport;
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

}
