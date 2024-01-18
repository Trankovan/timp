package com.example.timp;

import Logic.Database;
import Logic.Visitor;
import Logic.VisitorQueue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javafx.scene.control.TableRow;

import java.util.Random;

public class DataController {
    @FXML
    private TextField labelSurname;
    @FXML
    private TextField labelName;
    @FXML
    private TextField labelMiddleName;
    @FXML
    private TextField labelGender;
    @FXML
    private TextField labelDateOfBirth;
    @FXML
    private TextField labelIssueDate;
    @FXML
    private TextField labelWhoGive;
    @FXML
    private TextField labelSerialNumber;
    @FXML
    private TextField labelAddress;
    @FXML
    private TextField decisionTF;
    @FXML
    private TextField reasonTF;
    @FXML
    private Button queuePassportB;
    @FXML
    private Button decisionB;
    @FXML
    private ListView dataBaseLV;
    @FXML
    private AnchorPane anchorPane;
    private Database database = new Database();
    private VisitorQueue visitorQueue = new VisitorQueue();
    private Visitor currentVisitor;

    public void initialize() {
        // Путь к вашему текстовому файлу
        String filePath = "src/main/java/com.example.timp.DatabaseList.txt";

        // Создаем объект Database и импортируем данные из файла
        database.importDataFromFile(filePath);
        visitorQueue.importDataFromFile(filePath);
        controlGui();

    }

    private void nextVisitor() {
        Random random = new Random();
        int x = random.nextInt(visitorQueue.getVisitors().size());
        currentVisitor = visitorQueue.getVisitors().get(x);
        labelSurname.setText(currentVisitor.getPassport().getLastName());
        labelName.setText(currentVisitor.getPassport().getFirstName());
        labelMiddleName.setText(currentVisitor.getPassport().getMiddleName());
        labelSerialNumber.setText(currentVisitor.getPassport().getSeriesNumber());
        labelIssueDate.setText(currentVisitor.getPassport().getIssueDate());
        labelWhoGive.setText(currentVisitor.getPassport().getMaritalStatus());
        labelDateOfBirth.setText(currentVisitor.getPassport().getDateOfBirth());
        labelGender.setText(currentVisitor.getPassport().getSex());
        labelAddress.setText(currentVisitor.getPassport().getAddress());
    }

    private void controlGui() {
        anchorPane.setStyle("-fx-base: #D3D3D3;");

        queuePassportB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nextVisitor();
            }
        });

        decisionB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean flag = false;
                for (Visitor visitor: database.getVisitors()
                     ) {
                    if(visitor.getPassport().equals(currentVisitor.getPassport())){
                        flag=true;
                        decisionTF.setText("одобрен");
                        reasonTF.setText("");
                        return;
                    }
                }
                if(flag==false){
                    decisionTF.setText("не одобрен");
                    reasonTF.setText("иди нахуй");
                }
            }
        });

        labelSurname.setText("");
        labelSurname.setStyle("-fx-background-color:  transparent;-fx-font: 25 arial;");
        labelSurname.setMinHeight(60);
        labelSurname.setMaxWidth(200);
        labelSurname.setLayoutX(100);
        labelSurname.setLayoutY(390);
        labelSurname.setEditable(false);

        labelName.setText("");
        labelName.setStyle("-fx-background-color: transparent;-fx-font: 25 arial;");
        labelName.setMinHeight(60);
        labelName.setMaxWidth(200);
        labelName.setLayoutX(100);
        labelName.setLayoutY(490);
        labelName.setEditable(false);

        labelMiddleName.setText("");
        labelMiddleName.setStyle("-fx-background-color: #FFFFF0;-fx-font: 25 arial;");
        labelMiddleName.setMinHeight(60);
        labelMiddleName.setMaxWidth(200);
        labelMiddleName.setLayoutX(100);
        labelMiddleName.setLayoutY(590);
        labelMiddleName.setEditable(false);

        labelGender.setText("");
        labelGender.setStyle("-fx-background-color: #FFFFF0;-fx-font: 25 arial;");
        labelGender.setMinHeight(60);
        labelGender.setMaxWidth(200);
        labelGender.setLayoutX(100);
        labelGender.setLayoutY(690);
        labelGender.setEditable(false);

        labelDateOfBirth.setText("");
        labelDateOfBirth.setStyle("-fx-background-color: #FFFFF0;-fx-font: 25 arial;");
        labelDateOfBirth.setMinHeight(60);
        labelDateOfBirth.setMaxWidth(51);
        labelDateOfBirth.setLayoutX(1250);
        labelDateOfBirth.setLayoutY(390);
        labelDateOfBirth.setEditable(false);

        labelIssueDate.setText("");
        labelIssueDate.setStyle("-fx-background-color: #FFFFF0;-fx-font: 25 arial;");
        labelIssueDate.setMinHeight(60);
        labelIssueDate.setMaxWidth(51);
        labelIssueDate.setLayoutX(1250);
        labelIssueDate.setLayoutY(390);
        labelIssueDate.setEditable(false);

        ObservableList<String> langs = FXCollections.observableArrayList();
        langs.add("Имя Фамилия дата рождения");
        for (int i = 0; i < database.getVisitors().size(); i++) {
            langs.add(database.getVisitors().get(i).getPassport().toString());
        }
        dataBaseLV = new ListView<>(langs);
        dataBaseLV.setMinHeight(320);
        dataBaseLV.setMaxHeight(320);
        dataBaseLV.setMinWidth(300);
        dataBaseLV.setLayoutX(300);
        dataBaseLV.setLayoutY(60);
        anchorPane.getChildren().add(dataBaseLV);


    }
}
