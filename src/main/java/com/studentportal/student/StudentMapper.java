package com.studentportal.student;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto studentToStudentDto(Student student);
    Student studentDtoToStudent(StudentDto student);

}
