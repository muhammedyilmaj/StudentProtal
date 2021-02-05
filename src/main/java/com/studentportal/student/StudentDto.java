package com.studentportal.student;
import com.studentportal.department.Department;
import com.studentportal.department.DepartmentDto;
import com.studentportal.guardian.Guardian;
import com.studentportal.guardian.GuardianDto;
import com.studentportal.teacher.Teacher;
import com.studentportal.teacher.TeacherDto;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private Long id;
    private String name;
    private Guardian guardian;
    private Department department;
    private List<Teacher> teachers;
    private String grade;
}
