package com.studentportal.department;

import com.studentportal.faculty.Faculty;
import com.studentportal.lesson.Lesson;
import com.studentportal.student.Student;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentDto {

    private Long id;
    private  String departmentName;
    private List<Student> students;
    private String departmentType;
    private List<Lesson> lessons;
    private Faculty faculty;
}
