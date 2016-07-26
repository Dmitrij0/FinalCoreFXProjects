package com.gojavaonline3.shkurupiy.finalcore;

import com.gojavaonline3.shkurupiy.finalcore.model.Project;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FinalCoreController {

    @FXML
    private TableView<Project> projectTableView;

    @FXML
    private TableColumn<Project, String> projectNameColumn;

    @FXML
    public TabPane projectTabs;

    @FXML
    private Tab descriptionTab;

    @FXML
    public Tab umlTab;

    @FXML
    private Tab runnerTab;

    @FXML
    private Tab testerTab;

    @FXML
    public AnchorPane imageAnchorPane;

    @FXML
    public TextArea descriptionArea;

    @FXML
    public ImageView umlImageView;

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
        projectTableView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showProject(newValue));

        projectTabs.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showTab(newValue));

        imageAnchorPane.heightProperty()
                .addListener((observable, oldValue, newValue) -> umlImageView.setFitHeight((double)newValue));
        imageAnchorPane.widthProperty()
                .addListener((observable, oldValue, newValue) -> umlImageView.setFitWidth((double)newValue));
    }

    private void showTab(Tab tab) {
        if (projectTableView.getSelectionModel().getSelectedItem() == null) {
            projectTableView.getSelectionModel().select(projectTableView.getFocusModel().getFocusedIndex());
        }
        if (tab == descriptionTab) {
            descriptionArea.setText(projectTableView.getSelectionModel().getSelectedItem().getDescription());
        } else if (tab == umlTab) {
            final String imagePath = projectTableView.getSelectionModel().getSelectedItem().getUml();
            umlImageView.setImage(new Image(getClass().getResourceAsStream(imagePath)));
        }
    }

    private void showProject(Project project) {
        showTab(projectTabs.getSelectionModel().getSelectedItem());
    }

    public void setFinalCore(FinalCore finalCore) {
        this.finalCore = finalCore;
        projectTableView.setItems(finalCore.getProjectsData());
        projectTableView.getSelectionModel().select(0);
    }
}
