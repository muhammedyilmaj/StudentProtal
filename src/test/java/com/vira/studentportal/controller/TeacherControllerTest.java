package com.vira.studentportal.controller;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.student.Student;
import com.studentportal.teacher.Teacher;
import com.studentportal.teacher.TeacherController;
import com.studentportal.teacher.TeacherMapperImpl;
import com.studentportal.teacher.TeacherServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TeacherControllerTest {

    @Mock
    TeacherMapperImpl teacherMapper;

    @Mock
    TeacherServiceImpl teacherService;
    @InjectMocks
    TeacherController teacherController;

    @Before
    public void setup() {
        student.setName("adsf");
        student.setGrade("asdfsdf");
        student.setId(45L);
        studentList.add(student);
        teacher.setStudents(studentList);
        teacher.setTeacherName("banbala");
        teacher.setId(54L);
    }

    Teacher teacher = new Teacher();
    Student student= new Student();
    List<Student> studentList= new ArrayList<>();
    @Test
    public void Add_Teacher() throws StudentPortalException {
        Mockito.when(teacherService.add(Mockito.any(Teacher.class))).thenReturn(teacherMapper.teacherToTeacherDto(teacher));
        assertThat(teacherController.add(teacher).getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void Get_Teacher_By_Teacher_Id() throws StudentPortalException {
        Mockito.when(teacherService.getById(Mockito.any(Long.class))).thenReturn(teacherMapper.teacherToTeacherDto(teacher));
        assertThat(teacherController.getById(teacher.getId()).getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void Delete_Teacher_By_Teacher_Id() throws StudentPortalException {
        Mockito.when(teacherService.delete(Mockito.any(Long.class))).thenReturn(true);
        assertThat(teacherController.delete(teacher.getId()).getStatusCodeValue()).isEqualTo(200);
    }
}
