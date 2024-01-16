package org.example.task1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Иванов", 20, 3.3);
        try (FileOutputStream fileOut = new FileOutputStream("students.bin");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)){
            objectOut.writeObject(student);
            System.out.println("Объект Student успешно серилизован!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileInputStream fileIn = new FileInputStream("students.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Student res = (Student) objectIn.readObject();
            System.out.println("Объект Student десерилизован!");
            System.out.println(res);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}