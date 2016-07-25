package com.gojavaonline3.shkurupiy.finalcore;

import com.gojavaonline3.shkurupiy.finalcore.model.Project;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FinalCoreController {

    @FXML
    private TableView<Project> projectTableView;

    @FXML
    private TableColumn<Project, String> projectNameColumn;

    private FinalCore finalCore;

    public FinalCoreController() {
    }

    @FXML
    private void initialize() {
        projectNameColumn.setCellValueFactory(cellData -> cellData.getValue().projectNameProperty());

        projectTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showProject(newValue));
    }

    private void showProject(Project project) {
        if (project != null) {
            // Заполняем метки информацией из объекта person.
//            firstNameLabel.setText(person.getFirstName());
//            lastNameLabel.setText(person.getLastName());
//            streetLabel.setText(person.getStreet());
//            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
//            cityLabel.setText(person.getCity());
//
//            // TODO: Нам нужен способ для перевода дня рождения в тип String!
//            // birthdayLabel.setText(...);
//        } else {
//            // Если Person = null, то убираем весь текст.
//            firstNameLabel.setText("");
//            lastNameLabel.setText("");
//            streetLabel.setText("");
//            postalCodeLabel.setText("");
//            cityLabel.setText("");
//            birthdayLabel.setText("");
        }
    }

    public void setFinalCore(FinalCore finalCore) {
        this.finalCore = finalCore;
        projectTableView.setItems(finalCore.getProjectsData());
    }
}
