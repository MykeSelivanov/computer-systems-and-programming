package oop.filehandling1.serializationdeserialization;

import java.io.*;

public class SerializeDeserialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // open the file and the stream
        FileOutputStream fileOut = new FileOutputStream("/Users/mykhailoselivanov/Documents/growthhungry/computer-systems-and-programming-projects/computer-systems-and-programming/CSP-23-File-Handling-1/src/main/java/oop/filehandling1/serializationdeserialization/serialize-deserialize-test.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);

        // create the object and serialize it
        Employee employee = new Employee("John Doe", 30);
        outputStream.writeObject(employee);

        // close the stream and the file
        outputStream.close();
        fileOut.close();

        // open the stream and the file
        FileInputStream fileIn = new FileInputStream("/Users/mykhailoselivanov/Documents/growthhungry/computer-systems-and-programming-projects/computer-systems-and-programming/CSP-23-File-Handling-1/src/main/java/oop/filehandling1/serializationdeserialization/serialize-deserialize-test.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileIn);

        // deserialize the object
        Employee emp = (Employee) inputStream.readObject();

        // close the stream and the file
        inputStream.close();
        fileIn.close();

        // start using the object
        System.out.println("name: " + emp.getName() + " \nage: " + emp.getAge()); // name: John Doe age: 0 - age is transient field
    }
}
