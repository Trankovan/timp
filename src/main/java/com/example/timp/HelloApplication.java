package com.example.timp;

import Logic.Database;
import Logic.Visitor;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.collections.FXCollections;

// ...

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        // Получение контроллера и модели
        DataController controller = fxmlLoader.getController();
        Database database = new Database();

        // Импорт данных из файла (замените "путь/к/вашему/файлу.txt" на реальный путь)
        database.importDataFromFile("C:\\Users\\Иван\\Vsu.Course2\\OOP\\timp\\src\\main\\java\\Logic\\DatabaseList.txt");



        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
