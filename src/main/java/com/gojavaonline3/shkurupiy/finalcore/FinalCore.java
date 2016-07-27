package com.gojavaonline3.shkurupiy.finalcore;

import com.gojavaonline3.shkurupiy.finalcore.model.Project;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class FinalCore extends Application {

    private ObservableList<Project> projectsData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/FinalCoreController.fxml"));

        Parent root = loader.load();
        primaryStage.setTitle("GoIT GoJava#3 Shkurupiy's Group Final Core Project");
        primaryStage.setScene(new Scene(root, 1042, 761));
        primaryStage.show();

        FinalCoreController controller = loader.getController();
        controller.setFinalCore(this);
    }

    public ObservableList<Project> getProjectsData() {
        return projectsData;
    }

    public FinalCore() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(getClass().getResourceAsStream("/config.xml"), new ProjectParser(projectsData));
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        new FinalCore();
        launch(args);
    }
}
