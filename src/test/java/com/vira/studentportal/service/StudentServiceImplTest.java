package com.vira.studentportal.service;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.student.Student;
import com.studentportal.student.StudentRepo;
import com.studentportal.student.StudentServiceImpl;
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
public class StudentServiceImplTest {
    @InjectMocks
    StudentServiceImpl studentService;
    @Mock
    StudentRepo studentRepo;
    Student student;
    List<Student> studentList;
    @Before
    public void setup(){
        student= new Student();
        studentList= new ArrayList<>();
        student.setName("TEST");
        student.setId(345L);
        studentList.add(student);
    }

    @Test
    public void When_Save_Student_it_Should_Return_Student() throws StudentPortalException {
        Mockito.when(studentRepo.getOne(student.getId())).thenReturn(student);
        Student result= studentService.getById(student.getId());
        assertThat(result.getName()).isSameAs(student.getName());
    }
    @Test
    public void When_Get_Student_Id_Should_Return_Student() throws StudentPortalException {
        Mockito.when(studentRepo.getOne(324L)).thenReturn(student);
        Student result= studentService.getById(324L);
        assertThat(result.getId()).isSameAs(student.getId());
    }
    @Test
    public void When_getAll_Student_Should_Return_StudentList() throws StudentPortalException {
        Mockito.when(studentRepo.findAll()).thenReturn(studentList);
        List<Student> result= studentService.getAll();
        assertThat(result.get(0).getId()).isSameAs(student.getId());
    }
}

