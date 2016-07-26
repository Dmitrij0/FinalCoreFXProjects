package com.gojavaonline3.shkurupiy.finalcore;

import com.gojavaonline3.shkurupiy.finalcore.model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProjectParser extends DefaultHandler {

    private final ObservableList<Project> projectsData;
    private Project currProject;
    private String currentTag = "";
    private StringBuffer stringBuffer;

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
        stringBuffer = new StringBuffer();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if(value.trim().isEmpty()){
            return;
        }
        stringBuffer.append(value);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("name".equals(currentTag)){
            currProject.setProjectName(stringBuffer.toString());
        }
        if("description".equals(currentTag)){
            currProject.setDescription(stringBuffer.toString());
        }
        if("author".equals(currentTag)){
            currProject.setAuthorName(stringBuffer.toString());
        }
        if("runner".equals(currentTag)){
            currProject.setRunner(stringBuffer.toString());
        }
        if("tester".equals(currentTag)){
            currProject.setTester(stringBuffer.toString());
        }
        if("uml".equals(currentTag)){
            currProject.setUml(stringBuffer.toString());
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    public ObservableList<Project> getProjectsData() {
        return projectsData;
    }
}
