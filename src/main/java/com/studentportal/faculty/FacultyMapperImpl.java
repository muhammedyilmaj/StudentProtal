package com.studentportal.faculty;

import org.springframework.stereotype.Component;

@Component
public class FacultyMapperImpl implements FacultyMapper {

    @Override
    public FacultyDto facultyToFacultyDto(Faculty faculty) {
        return (FacultyDto) converter(faculty);
    }

    @Override
    public Faculty facultyDtoToFaculty(FacultyDto facultyDto) {
        return (Faculty) converter(facultyDto);
    }
    private Object converter(Object object) {

        if (object instanceof Faculty) {
            FacultyDto facultyDto = new FacultyDto();
            facultyDto.setId(((Faculty) object).getId());
            facultyDto.setDepartment(((Faculty) object).getDepartment());
            facultyDto.setFacultyName(((Faculty) object).getFacultyName());
            return facultyDto;
        }
        else if (object instanceof FacultyDto) {
            Faculty faculty = new Faculty();
            faculty.setId(((FacultyDto) object).getId());
            faculty.setDepartment(((FacultyDto) object).getDepartment());
            faculty.setFacultyName(((FacultyDto) object).getFacultyName());
            return faculty;
        }
        else {
            return null;
        }
    }

}
