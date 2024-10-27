package oop.filehandling1.copyfiles;

import java.io.*;

public class CopyFromOneFileToAnother {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        System.out.println(new File(".").getAbsolutePath());


        try {
            in = new FileInputStream("/Users/mykhailoselivanov/Documents/growthhungry/computer-systems-and-programming-projects/computer-systems-and-programming/CSP-23-File-Handling-1/src/main/java/oop/filehandling1/copyfiles/testChars.txt");
            out = new FileOutputStream("/Users/mykhailoselivanov/Documents/growthhungry/computer-systems-and-programming-projects/computer-systems-and-programming/CSP-23-File-Handling-1/src/main/java/oop/filehandling1/copyfiles/copied-testChars.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
