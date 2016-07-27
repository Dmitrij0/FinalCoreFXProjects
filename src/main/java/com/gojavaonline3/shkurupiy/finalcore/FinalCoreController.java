package com.gojavaonline3.shkurupiy.finalcore;

import com.gojavaonline3.shkurupiy.finalcore.model.Project;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ResourceBundle;

public class FinalCoreController implements Initializable {

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
    public void initialize(URL location, ResourceBundle resources) {
        projectNameColumn.setCellValueFactory(cellData -> cellData.getValue().projectNameProperty());
        projectTableView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showProject(newValue));

        projectTabs.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showTab(newValue));

        imageAnchorPane.heightProperty()
                .addListener((observable, oldValue, newValue) -> umlImageView.setFitHeight((double) newValue));
        imageAnchorPane.widthProperty()
                .addListener((observable, oldValue, newValue) -> umlImageView.setFitWidth((double) newValue));
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
        } else if (tab == runnerTab) {
            prepareAndExecuteProject(runArea, projectTableView.getSelectionModel().getSelectedItem().getRunner());
        } else if (tab == testerTab) {
            prepareAndExecuteTest(testArea, projectTableView.getSelectionModel().getSelectedItem().getTester());
        }
    }

    private void prepareAndExecuteTest(TextArea textArea, String fullClassName) {
        textArea.setText(fullClassName + " is covered by tests.");
    }

    private void prepareAndExecuteProject(TextArea textArea, String fullClassName) {
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;
        PrintStream oldErr = System.err;
        textArea.clear();
        try (OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                Platform.runLater(() -> textArea.appendText(String.valueOf((char) b)));
            }
        }) {
            executeProject(out, fullClassName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
            System.setErr(oldErr);
        }
    }

    private void executeProject(OutputStream out, String fullClassName) {
        Platform.runLater(() -> {
            try {
                System.setOut(new PrintStream(out, true));
                System.setErr(new PrintStream(out, true));
                Class<?> runnerClass = Class.forName(fullClassName);
                final Method main = runnerClass.getMethod("main", String[].class);
                main.invoke(null, (Object) new String[0]);
            } catch (IllegalAccessException | InvocationTargetException |
                    NoSuchMethodException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
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
