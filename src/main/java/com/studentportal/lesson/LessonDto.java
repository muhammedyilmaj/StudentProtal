package com.studentportal.lesson;


import com.studentportal.department.DepartmentDto;
import com.studentportal.student.StudentDto;
import com.studentportal.teacher.TeacherDto;
import lombok.Data;
import java.util.List;

@Data
public class LessonDto {

    private Long id;

    private String lessonName;
    private List<String> lessoncClass;
    private DepartmentDto department;
    private List<TeacherDto> teachers;
    private List<StudentDto> students;

}
