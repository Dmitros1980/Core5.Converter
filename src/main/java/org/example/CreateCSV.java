package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CreateCSV {
    private String fileText;
    private String fileName;
    private String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
    private String[] nextLine;

    public static void createCSV(String fileText, String fileName) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName, true))) {
            String[] employee = fileText.split(",");
            writer.writeNext(employee);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    public static void parseCSV(String[] columnMapping, String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                System.out.println(Arrays.toString(nextLine));
            }
        } catch (IOException |
                 CsvValidationException e) {
            e.printStackTrace();
        }

    }

    public static List<Employee> parse_CSV(String[] columnMapping, String fileName) {
        List<Employee> data = null;
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy =
                    new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();
            data = csv.parse();
            data.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


}
