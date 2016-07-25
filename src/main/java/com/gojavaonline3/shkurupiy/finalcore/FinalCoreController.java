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
    @FXML
    private TableColumn<Project, String> authorNameColumn;

    private FinalCore finalCore;

    public FinalCoreController() {
    }

    @FXML
    private void initialize() {
        projectNameColumn.setCellValueFactory(cellData -> cellData.getValue().projectNameProperty());
        authorNameColumn.setCellValueFactory(cellData -> cellData.getValue().authorNameProperty());
    }

    public void setFinalCore(FinalCore finalCore) {
        this.finalCore = finalCore;
        projectTableView.setItems(finalCore.getProjectsData());
    }
}
