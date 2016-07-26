package com.gojavaonline3.shkurupiy.finalcore.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Project {

    private StringProperty projectName;
    private StringProperty description;
    private StringProperty authorName;
    private StringProperty runner;
    private StringProperty tester;
    private StringProperty uml;

    public Project() {
        this(null, null, null, null, null, null);
    }

    public Project(String projectName, String description, String authorName,
                   String runner, String tester, String uml) {
        this.projectName = new SimpleStringProperty(projectName);
        this.description = new SimpleStringProperty(description);
        this.authorName = new SimpleStringProperty(authorName);
        this.runner = new SimpleStringProperty(runner);
        this.tester = new SimpleStringProperty(tester);
        this.uml = new SimpleStringProperty(uml);
    }

    public String getProjectName() {
        return projectName.get();
    }

    public StringProperty projectNameProperty() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName.set(projectName);
    }

    public String getAuthorName() {
        return authorName.get();
    }

    public StringProperty authorNameProperty() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName.set(authorName);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getRunner() {
        return runner.get();
    }

    public StringProperty runnerProperty() {
        return runner;
    }

    public void setRunner(String runner) {
        this.runner.set(runner);
    }

    public String getTester() {
        return tester.get();
    }

    public StringProperty testerProperty() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester.set(tester);
    }

    public String getUml() {
        return uml.get();
    }

    public StringProperty umlProperty() {
        return uml;
    }

    public void setUml(String uml) {
        this.uml.set(uml);
    }

}