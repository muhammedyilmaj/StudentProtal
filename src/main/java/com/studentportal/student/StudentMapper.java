package com.studentportal.student;

import com.studentportal.lesson.Lesson;
import com.studentportal.lesson.LessonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto studentToStudentDto(Student student);
    Student studentDtoToStudent(StudentDto student);

}
