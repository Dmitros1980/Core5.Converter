package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserXML {
    private String fileName;

    static List<Employee> parserXML(String fileName) throws ParserConfigurationException, IOException, SAXException {

        ArrayList<Employee> employees = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));

        NodeList employeeElements = doc.getDocumentElement().getElementsByTagName("employee");

        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);

            employees.add(new Employee(Long.parseLong(employee.getChildNodes().item(1).getTextContent()),
                    employee.getChildNodes().item(3).getTextContent(),
                    employee.getChildNodes().item(5).getTextContent(),
                    employee.getChildNodes().item(7).getTextContent(),
                    Integer.parseInt(employee.getChildNodes().item(9).getTextContent())));
        }
        return employees;
    }


}
