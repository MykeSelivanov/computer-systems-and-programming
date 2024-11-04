package oop.filebaseddatabase;

import oop.filebaseddatabase.entities.Academy;
import oop.filebaseddatabase.repository.AcademyRepository;
import oop.filebaseddatabase.repository.DbContext;
import oop.filebaseddatabase.repository.IRepository;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        DbContext context = new DbContext("/Users/mykhailoselivanov/Documents/growthhungry/computer-systems-and-programming-projects/computer-systems-and-programming/CSP-24-File-Based-Database/src/main/java/oop/filebaseddatabase/db");

        IRepository<Academy> academyIRepository = new AcademyRepository(context);
        academyIRepository.Add(new Academy(0, "Test description"));

        for(Academy academy: academyIRepository.GetAll()) {
            System.out.println(academy.getId() + " " + academy.getDescription());
        }
    }
}
