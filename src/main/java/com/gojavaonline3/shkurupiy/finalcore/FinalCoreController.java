package com.gojavaonline3.shkurupiy.finalcore;

import com.gojavaonline3.shkurupiy.finalcore.model.Project;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class FinalCoreController {

    @FXML
    private TableView<Project> projectTableView;

    @FXML
    private TableColumn<Project, String> projectNameColumn;

    @FXML
    private Tab descriptionTab;

    @FXML
    private Tab runnerTab;

    @FXML
    private Tab testerTab;

    @FXML
    public TextArea descriptionArea;

    @FXML
    public TextArea runArea;

    @FXML
    public TextArea testArea;


    private FinalCore finalCore;

    public FinalCoreController() {
    }

    @FXML
    private void initialize() {

        projectNameColumn.setCellValueFactory(cellData -> cellData.getValue().projectNameProperty());
        projectTableView.getSelectionModel()
                .selectedItemProperty().addListener((observable, oldValue, newValue) -> showProject(newValue));

        projectTableView.getSelectionModel().select(0);
    }

    private void showProject(Project project) {
        if (project != null) {
            descriptionArea.setText(project.getDescription());
        } else {
            descriptionArea.setText("");
        }
    }

    public void setFinalCore(FinalCore finalCore) {
        this.finalCore = finalCore;
        projectTableView.setItems(finalCore.getProjectsData());
    }
}
