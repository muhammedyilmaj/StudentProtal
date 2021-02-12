package com.studentportal.student;

import com.studentportal.lesson.Lesson;
import com.studentportal.lesson.LessonDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDto studentToStudentDto(Student student) {
        if( student == null ) {
            return null;
        }
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setGrade(student.getGrade());
        studentDto.setDepartment(student.getDepartment());
        studentDto.setName(student.getName());
        studentDto.setGuardian(student.getGuardian());
        studentDto.setTeachers(student.getTeachers());

        return studentDto;
    }

}
