package com.studentportal.faculty;

import com.studentportal.department.Department;
import com.studentportal.department.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FacultyMapper {

    FacultyMapper INSTANCE = Mappers.getMapper(FacultyMapper.class);

    FacultyDto facultyToFacultyDto(Faculty faculty);
}
