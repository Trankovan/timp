package Logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Visitor> visitors;

    public Database() {
        this.visitors = new ArrayList<>();
    }

    public void importDataFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Парсим строку и добавляем посетителя в базу данных
                Visitor visitor = parseVisitorData(line);
                if (visitor != null) {
                    visitors.add(visitor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Visitor parseVisitorData(String data) {

        String[] parts = data.split(";");
        if (parts.length == 9) {
            String fullName = parts[0];
            Passport passport = new Passport(parts[1], parts[2], parts[3], parts[4],
                    parts[5], parts[6], parts[7], parts[8]);
            InternationalPassport internationalPassport = new InternationalPassport(/*данные*/);
            Visa visa = new Visa(/*данные*/);


            return new Visitor(fullName, passport, visa);
        } else {
            System.out.println("Ошибка при парсинге строки: " + data);
            return null;
        }
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public boolean decideToAllowEntry(String fullName) {
        Visitor visitor = getVisitor(fullName);

        if (visitor != null) {
            return true;
        }

        return false;
    }


    private Visitor getVisitor(String fullName) {
        for (Visitor visitor : visitors) {
            if (visitor.getFullName().equals(fullName)) {
                return visitor;
            }
        }
        return null;
    }
}
