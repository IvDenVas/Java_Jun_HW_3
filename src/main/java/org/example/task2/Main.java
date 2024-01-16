package org.example.task2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Петров", 18, 4.5);
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();
        File fileJson = new File("file.json");
        File fileXml = new File("file.xml");

        //серилизация
        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(fileJson, student);
            System.out.println("Объект Student серилизован в файл file.json");
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.writeValue(fileXml, student);
            System.out.println("Объект Student серилизован в файл file.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //десерилизация
        try {
            System.out.println("Десерилизация из json");
            Student student1 = objectMapper.readValue(fileJson, Student.class);
            System.out.println(student1);
            System.out.println("Десерилизация из xml");
            Student student2 = xmlMapper.readValue(fileXml, Student.class);
            System.out.println(student2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
