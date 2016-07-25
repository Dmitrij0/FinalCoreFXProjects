package com.gojavaonline3.shkurupiy.finalcore;

import com.gojavaonline3.shkurupiy.finalcore.model.Project;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProjectParser extends DefaultHandler {

    private final ObservableList<Project> projectsData;
    private Project currProject;
    private String currentTag = "";

    public ProjectParser() {
        projectsData = FXCollections.observableArrayList();
    }

    public ProjectParser(ObservableList<Project> projectsData) {
        this.projectsData = projectsData;
    }

    @Override
    public void startDocument() throws SAXException {
        projectsData.clear();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTag = qName;
        if ("Project".equals(qName)) {
            currProject = new Project();
            projectsData.add(currProject);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if(value.trim().isEmpty()){
            return;
        }
        if("name".equals(currentTag)){
            currProject.setProjectName(value);
        }
        if("description".equals(currentTag)){
            currProject.setDescription(value);
        }
        if("author".equals(currentTag)){
            currProject.setAuthorName(value);
        }
        if("runner".equals(currentTag)){
            currProject.setRunner(value);
        }
        if("tester".equals(currentTag)){
            currProject.setTester(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    public ObservableList<Project> getProjectsData() {
        return projectsData;
    }
}
