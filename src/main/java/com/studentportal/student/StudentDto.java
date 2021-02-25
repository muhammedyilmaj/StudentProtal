package com.studentportal.student;
import com.studentportal.department.DepartmentDto;
import com.studentportal.guardian.GuardianDto;
import com.studentportal.teacher.TeacherDto;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private Long id;
    private String name;
    private GuardianDto guardian;
    private DepartmentDto department;
    private List<TeacherDto> teachers;
    private String grade;
}
