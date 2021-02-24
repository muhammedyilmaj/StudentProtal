package com.studentportal.faculty;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface FacultyMapper {

    FacultyMapper INSTANCE = Mappers.getMapper(FacultyMapper.class);

    FacultyDto facultyToFacultyDto(Faculty faculty);
    Faculty facultyDtoToFaculty(FacultyDto facultyDto);

}
