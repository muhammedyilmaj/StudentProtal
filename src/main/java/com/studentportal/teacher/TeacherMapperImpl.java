package com.studentportal.teacher;

import org.springframework.stereotype.Component;

@Component
public class TeacherMapperImpl implements TeacherMapper{

    @Override
    public TeacherDto teacherToTeacherDto(Teacher teacher) {
        if( teacher == null ) {
            return null;
        }
        return (TeacherDto)converter(teacher);
    }

    @Override
    public Teacher teacherDtoToTeacher(TeacherDto teacher) {
        return (Teacher)converter(teacher);
    }
    private Object converter(Object object) {

        if (object instanceof Teacher) {
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.setId(((Teacher) object).getId());
            teacherDto.setLessons(((Teacher) object).getLessons());
            teacherDto.setStudents(((Teacher) object).getStudents());
            teacherDto.setTeacherName(((Teacher) object).getTeacherName());
            return teacherDto;
        }
        else if (object instanceof TeacherDto) {
            Teacher teacher = new Teacher();
            teacher.setId(((TeacherDto) object).getId());
            teacher.setLessons(((TeacherDto) object).getLessons());
            teacher.setStudents(((TeacherDto) object).getStudents());
            teacher.setTeacherName(((TeacherDto) object).getTeacherName());
            return teacher;
        }
        else {
            return null;
        }
    }
}
