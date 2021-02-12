package com.studentportal.teacher;

import org.springframework.stereotype.Component;

@Component
public class TeacherMapperImpl implements TeacherMapper{

    @Override
    public TeacherDto teacherToTeacherDto(Teacher teacher) {
        if( teacher == null ) {
            return null;
        }
        TeacherDto teacherDto= new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setLessons(teacher.getLessons());
        teacherDto.setStudents(teacher.getStudents());
        teacherDto.setTeacherName(teacher.getTeacherName());
        return teacherDto;
    }
}
