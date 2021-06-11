package com.vira.studentportal.controller;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.student.Student;
import com.studentportal.student.StudentDto;
import com.studentportal.teacher.*;
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
        studentDto.setName("adsf");
        studentDto.setGrade("asdfsdf");
        studentDto.setId(45L);
        studentListDto.add(studentDto);
        teacherDto.setStudents(studentListDto);
        teacherDto.setTeacherName("banbala");
        teacherDto.setId(54L);
    }

    Teacher teacher = new Teacher();
    Student student= new Student();
    List<Student> studentList= new ArrayList<>();

    TeacherDto teacherDto = new TeacherDto();
    StudentDto studentDto = new StudentDto();
    List<StudentDto> studentListDto = new ArrayList<>();
    @Test
    public void Add_Teacher() throws StudentPortalException {
        Mockito.when(teacherService.add(Mockito.any(TeacherDto.class))).thenReturn(teacherDto);
        assertThat(teacherController.add(teacherDto).getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void Get_Teacher_By_Teacher_Id() throws StudentPortalException {
        Mockito.when(teacherService.getById(Mockito.any(Long.class))).thenReturn(teacherDto);
        assertThat(teacherController.getById(teacher.getId()).getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void Delete_Teacher_By_Teacher_Id() throws StudentPortalException {
        Mockito.when(teacherService.delete(Mockito.any(Long.class))).thenReturn(true);
        assertThat(teacherController.delete(teacher.getId()).getStatusCodeValue()).isEqualTo(200);
    }
}
