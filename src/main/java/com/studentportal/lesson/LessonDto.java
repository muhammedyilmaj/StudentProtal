package com.studentportal.lesson;


import com.studentportal.department.Department;
import com.studentportal.student.Student;
import com.studentportal.teacher.Teacher;
import lombok.Data;
import java.util.List;

@Data
public class LessonDto {

    private Long id;

    private String lessonName;
    private List<String> lessonClass;
    private Department department;
    private List<Teacher> teachers;
    private List<Student> students;

}
