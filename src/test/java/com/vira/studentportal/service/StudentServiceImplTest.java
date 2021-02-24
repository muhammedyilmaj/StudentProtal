package com.vira.studentportal.service;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.student.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    StudentServiceImpl studentService;
    @Mock
    StudentRepo studentRepo;
    Student student;
    List<Student> studentList;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        studentService = new StudentServiceImpl(studentRepo, StudentMapper.INSTANCE);
        student = new Student();
        studentList = new ArrayList<>();
        student.setName("TEST");
        student.setId(345L);
        studentList.add(student);
    }

    @Test
    public void When_Save_Student_it_Should_Return_Student() throws StudentPortalException {
        Mockito.when(studentRepo.save(student)).thenReturn(student);
        StudentDto result = studentService.save(StudentMapper.INSTANCE.studentToStudentDto(student));
        assertThat(result.getName()).isSameAs(student.getName());
    }
    @Test
    public void When_Get_Student_Id_Should_Return_Student() throws StudentPortalException {
        Mockito.when(studentRepo.getOne(anyLong())).thenReturn(student);
        StudentDto result = studentService.getById(324L);
        assertThat(result.getId()).isSameAs(student.getId());
    }
    @Test
    public void When_getAll_Student_Should_Return_StudentList() throws StudentPortalException {
        Mockito.when(studentRepo.findAll()).thenReturn(studentList);
        List<StudentDto> result = studentService.getAll();
        assertThat(result.get(0).getId()).isSameAs(student.getId());
    }
}

