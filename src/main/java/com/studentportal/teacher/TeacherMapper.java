package com.studentportal.teacher;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDto teacherToTeacherDto(Teacher teacher);
    Teacher teacherDtoToTeacher(TeacherDto teacher);

}
