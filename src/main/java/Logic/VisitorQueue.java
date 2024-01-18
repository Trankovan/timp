package Logic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitorQueue {
    private List<Visitor> visitors;

    public VisitorQueue() {
        this.visitors = new ArrayList<>();
    }

    public void importDataFromFile(String filePath) {
        try (Scanner reader = new Scanner(Path.of("src/main/resources/com/example/timp/QueueAtPassportСontrol.txt")) ) {
            String line;
            while (reader.hasNext()) {
                line = reader.nextLine();
                // Парсим строку и добавляем посетителя в базу данных
                Visitor visitor = parseVisitorData(line);
                if (visitor != null) {
                    visitors.add(visitor);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Visitor parseVisitorData(String data) {

        String[] parts = data.split(";");
        if (parts.length == 9) {
            Passport passport = new Passport(parts[0],parts[1], parts[2], parts[3], parts[4],
                    parts[5], parts[6], parts[7],parts[8]);


            return new Visitor(passport.getLastName()+" "+passport.getFirstName(), passport);
        } else {
            System.out.println("Ошибка при парсинге строки: " + data);
            return null;
        }
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

}
