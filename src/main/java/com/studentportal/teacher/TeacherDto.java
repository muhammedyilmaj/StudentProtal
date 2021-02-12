package com.studentportal.teacher;

import com.studentportal.lesson.Lesson;
import com.studentportal.student.Student;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class TeacherDto {

    private Long id;
    private List<Student> students;
    private List<Lesson> lessons= new ArrayList<>();
    private String teacherName;

}
