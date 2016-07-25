package com.gojavaonline3.shkurupiy.finalcore.model;

import javafx.beans.property.StringProperty;

public class Project {

    private StringProperty projectName;
    private StringProperty description;
    private StringProperty authorName;
    private StringProperty runner;
    private StringProperty tester;

    public Project() {
        this(null, null, null, null, null);
    }

    public Project(StringProperty projectName, StringProperty description,
                   StringProperty authorName, StringProperty runner, StringProperty tester) {
        this.projectName = projectName;
        this.description = description;
        this.authorName = authorName;
        this.runner = runner;
        this.tester = tester;
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
}