package com.studentportal.guardian;

import com.studentportal.student.StudentDto;
import lombok.Data;
import java.util.List;

@Data
public class GuardianDto {

    private Long id;
    private String name;
    private List<StudentDto> students;

}
