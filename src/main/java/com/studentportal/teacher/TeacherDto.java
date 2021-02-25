package com.studentportal.teacher;

import com.studentportal.lesson.LessonDto;
import com.studentportal.student.StudentDto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class TeacherDto {

    private Long id;
    private List<StudentDto> students;
    private List<LessonDto> lessons= new ArrayList<>();
    private String teacherName;

}
