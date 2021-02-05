package com.studentportal.faculty;

import com.studentportal.department.Department;
import lombok.Data;
import java.util.List;

@Data
public class FacultyDto {

    private Long id;
    private String facultyName;
    List<Department> department;

}
