package oop.filebaseddatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class DbBackup {
    private final String FILENAME;

    public DbBackup(String fileName) {
        FILENAME = fileName;
    }

    public void RunEvery(int minutes, int seconds) {
        int milliseconds = minutes * 60 * 1000 + seconds * 1000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Running backup every " + minutes + "minutes, " + seconds + " seconds...");
                CreateNewVersion();
            }
        },0, milliseconds);
    }

    public void CreateNewVersion() {
        try (FileInputStream inputStream = new FileInputStream(FILENAME);
             FileOutputStream outputStream = new FileOutputStream(CreateNewFileName())) {

            byte [] buffer = new byte[1024];
            int bytesRead;

            while((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String CreateNewFileName() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String timestampString = now.format(formatter);
        return FILENAME + "_" + timestampString;
    }
}
