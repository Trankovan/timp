package com.example.timp;

import Logic.Database;
import Logic.Visitor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableRow;

import javafx.scene.control.TableRow;

public class DataController {
    @FXML
    private TableView<Visitor> passportDatabaseTable;
    @FXML
    private TableColumn<Visitor, String> firstNameColumn;
    @FXML
    private TableColumn<Visitor, String> lastNameColumn;
    // Добавьте другие TableColumn для остальных атрибутов

    public TableView<Visitor> getPassportDatabaseTable() {
        return passportDatabaseTable;
    }

    public void initialize() {
        // Путь к вашему текстовому файлу
        String filePath = "C:\\Users\\Иван\\Vsu.Course2\\OOP\\timp\\src\\main\\java\\Logic\\DatabaseList.txt";

        // Создаем объект Database и импортируем данные из файла
        Database database = new Database();
        database.importDataFromFile(filePath);

        // Получаем список посетителей из базы данных
        for (Visitor visitor : database.getVisitors()) {
            // Создаем Label для каждого посетителя
            Label visitorLabel = new Label(getVisitorInfo(visitor));

            // Добавляем Label в контейнер

        }
    }

    private String getVisitorInfo(Visitor visitor) {
        // Здесь форматируем информацию о посетителе для отображения в Label
        return "Имя: " + visitor.getFullName() +
                ", Паспорт: " + visitor.getPassport().getSeriesNumber() +
                ", Виза: " + visitor.getVisa().getVisaType();
    }
}
