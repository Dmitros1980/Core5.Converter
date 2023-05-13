package org.example;

import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.example.CreateCSV.parseCSV;
import static org.example.CreateCSV.parse_CSV;
import static org.example.CreateJSON.listToJson;
import static org.example.ParserXML.parserXML;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        System.out.println("Hello world!");
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName2 = "data.xml";
        String fileName5 = "data2.xml";
        String fileName3="data2.json";
        String fileName = "data.csv";
        String fileName1 = "data.json";
        CreateCSV.createCSV("1,John,Smith,USA,25", fileName);
        CreateCSV.createCSV("2,Ivan,Petrov,RU,23", fileName);
        CreateCSV.parseCSV(columnMapping, fileName);
        List<Employee> list = parse_CSV(columnMapping, fileName);
        CreateJSON.writeString(listToJson(list),fileName1);

         parserXML(fileName2);
         String list1= listToJson(parserXML(fileName2));
         CreateJSON.writeString(list1.toString(),fileName3);
    }
}