package com.studentportal.department;

import com.studentportal.faculty.FacultyDto;
import com.studentportal.lesson.LessonDto;
import com.studentportal.student.StudentDto;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentDto {

    private Long id;
    private String departmentName;
    private List<StudentDto> students;
    private String departmentType;
    private List<LessonDto> lessons;
    private FacultyDto faculty;
}
