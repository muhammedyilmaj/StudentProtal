package com.vira.studentportal.controller;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.guardian.Guardian;
import com.studentportal.guardian.GuardianController;
import com.studentportal.guardian.GuardianServiceImpl;
import com.studentportal.student.Student;
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
public class GuardianControllerTest {
    @Mock
    GuardianServiceImpl guardianService;
    @InjectMocks
    GuardianController guardianController;

    @Before
    public void setup() {
        student.setName("muhammed");
        student.setGrade("son");
        studentList.add(student);
        guardian.setStudents(studentList);
        guardian.setName("Mock");
        guardian.setId(34L);
    }

    Guardian guardian = new Guardian();
    Student student=new Student();
    List<Student> studentList=new ArrayList<>();
    @Test
    public void Add_Guardian() throws StudentPortalException {
        Mockito.when(guardianService.add(Mockito.any(Guardian.class))).thenReturn(guardian);
        assertThat(guardianController.add(guardian).getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void Get_Guardian_By_Guardian_Id() throws StudentPortalException {
        Mockito.when(guardianService.getById(Mockito.any(Long.class))).thenReturn(guardian);
        assertThat(guardianController.getById(guardian.getId()).getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void Delete_Guardian_By_Guardian_Id() throws StudentPortalException {
        Mockito.when(guardianService.delete(Mockito.any(Long.class))).thenReturn(true);
        assertThat(guardianController.delete(guardian.getId()).getStatusCodeValue()).isEqualTo(200);
    }
}