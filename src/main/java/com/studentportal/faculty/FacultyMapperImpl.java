package com.studentportal.faculty;

import com.studentportal.department.Department;
import com.studentportal.department.DepartmentDto;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapperImpl implements FacultyMapper {

    @Override
    public FacultyDto facultyToFacultyDto(Faculty faculty) {
        if( faculty == null ) {
            return null;
        }
        FacultyDto facultyDto = new FacultyDto();
        facultyDto.setId(faculty.getId());
        facultyDto.setDepartment(faculty.getDepartment());
        facultyDto.setFacultyName(faculty.getFacultyName());

        return facultyDto;
    }

}
