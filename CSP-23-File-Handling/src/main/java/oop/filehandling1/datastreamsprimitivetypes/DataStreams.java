package oop.filehandling1.datastreamsprimitivetypes;

import java.io.*;

public class DataStreams {
    public static void main(String[] args) throws IOException {

        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;

        try {
            // Writing primitive data types to a file using DataOutputStream
            outputStream = new DataOutputStream(new FileOutputStream("/Users/mykhailoselivanov/Documents/growthhungry/computer-systems-and-programming-projects/computer-systems-and-programming/CSP-23-File-Handling-1/src/main/java/oop/filehandling1/datastreamsprimitivetypes/test-datastreams.txt"));
            outputStream.writeInt(42);
            outputStream.writeDouble(3.14159);
            outputStream.writeBoolean(true);
            outputStream.writeUTF("Hello, Data Streams!");

            // Reading primitive data types from the file using DataInputStream
            inputStream = new DataInputStream(new FileInputStream("/Users/mykhailoselivanov/Documents/growthhungry/computer-systems-and-programming-projects/computer-systems-and-programming/CSP-23-File-Handling-1/src/main/java/oop/filehandling1/datastreamsprimitivetypes/test-datastreams.txt"));
            int intValue = inputStream.readInt();
            double doubleValue = inputStream.readDouble();
            boolean booleanValue = inputStream.readBoolean();
            String stringValue = inputStream.readUTF();

            System.out.println("Read values: ");
            System.out.println("Int: " + intValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("Boolean: " + booleanValue);
            System.out.println("String: " + stringValue);

        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
