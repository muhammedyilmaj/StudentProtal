package com.studentportal.student;

import com.studentportal.lesson.LessonDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDto studentToStudentDto(Student student) {
        return (StudentDto) converter(student);
    }

    @Override
    public Student studentDtoToStudent(StudentDto student) {
        return (Student) converter(student);
    }
    private Object converter(Object object) {

        if (object instanceof Student) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(((Student) object).getId());
            studentDto.setGrade(((Student) object).getGrade());
            studentDto.setDepartment(((Student) object).getDepartment());
            studentDto.setName(((Student) object).getName());
            studentDto.setGuardian(((Student) object).getGuardian());
            studentDto.setTeachers(((Student) object).getTeachers());
            return studentDto;
        }
        else if (object instanceof LessonDto) {
            Student student = new Student();
            student.setId(((StudentDto) object).getId());
            student.setGrade(((StudentDto) object).getGrade());
            student.setDepartment(((StudentDto) object).getDepartment());
            student.setName(((StudentDto) object).getName());
            student.setGuardian(((StudentDto) object).getGuardian());
            student.setTeachers(((StudentDto) object).getTeachers());
            return student;
        }
        else {
            return null;
        }
    }
}
