package com.studentportal.bootstrap;

import com.studentportal.faculty.Faculty;
import com.studentportal.faculty.FacultyRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private FacultyRepo facultyRepo;

    public Bootstrap(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Faculty faculty = new Faculty ();
        faculty.setFacultyName("Computer Science");
        facultyRepo.save(faculty);
        System.out.println("data loaded" + facultyRepo.count());
    }
}
