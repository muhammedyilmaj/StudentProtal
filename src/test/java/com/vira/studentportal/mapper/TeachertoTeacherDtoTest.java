package com.vira.studentportal.mapper;

import com.studentportal.teacher.Teacher;
import com.studentportal.teacher.TeacherDto;
import com.studentportal.teacher.TeacherMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TeachertoTeacherDtoTest {
    public static final String TEACHER_NAME = "MY";
    public static final long ID = 1L;
    TeacherMapper teacherMapper = TeacherMapper.INSTANCE;
    @Test
    public void teacherToTeacherDto() {
        //given
        Teacher teacher = new Teacher();
        teacher.setId(ID);
        teacher.setTeacherName(TEACHER_NAME);

        //when
        TeacherDto teacherDto =  teacherMapper.teacherToTeacherDto(teacher);

        //then
        assertEquals(Long.valueOf(ID), teacherDto.getId());
        assertEquals(TEACHER_NAME, teacherDto.getTeacherName());
    }
}
