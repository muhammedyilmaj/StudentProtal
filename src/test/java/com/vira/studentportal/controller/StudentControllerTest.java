package com.vira.studentportal.controller;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.student.Student;
import com.studentportal.student.StudentController;
import com.studentportal.student.StudentDto;
import com.studentportal.student.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {
    @Mock
    StudentServiceImpl studentService;
    @InjectMocks
    StudentController studentController;

    @Before
    public void setup() {
        student.setGrade("ne bilem");
        student.setName("ragors");
        student.setId(4L);
        studentDto.setGrade("ne bilem");
        studentDto.setName("ragors");
        studentDto.setId(4L);
    }
    StudentDto studentDto = new StudentDto();
    Student student = new Student();
    @Test
    public void Add_Student() throws StudentPortalException {
        Mockito.when(studentService.save(Mockito.any(StudentDto.class))).thenReturn(studentDto);
        assertThat(studentController.add(studentDto).getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void Get_Student_By_Student_Id() throws StudentPortalException {
        Mockito.when(studentService.getById(Mockito.any(Long.class))).thenReturn(studentDto);
        assertThat(studentController.getById(student.getId()).getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void Delete_Student_By_Student_Id() throws StudentPortalException {
        Mockito.when(studentService.delete(Mockito.any(Long.class))).thenReturn(true);
        assertThat(studentController.delete(student.getId()).getStatusCodeValue()).isEqualTo(200);
    }
}
