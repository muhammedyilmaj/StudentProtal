package com.vira.studentportal.service;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.teacher.Teacher;
import com.studentportal.teacher.TeacherRepo;
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
public class TeacherServiceImplTest {

    @InjectMocks
    TeacherServiceImpl teacherService;
    @Mock
    TeacherRepo teacherRepo;
    Teacher teacher;
    List<Teacher> teacherList;
    @Before
    public void setup()
    {
        teacher= new Teacher();
        teacherList= new ArrayList<>();
        teacher.setTeacherName("TEST");
        teacher.setId(345L);
        teacherList.add(teacher);
    }
    @Test
    public void When_Save_Teacher_it_Should_Return_Teacher() throws StudentPortalException {
        Mockito.when(teacherRepo.getOne(teacher.getId())).thenReturn(teacher);
        Teacher result= teacherService.getById(teacher.getId());
        assertThat(result.getTeacherName()).isSameAs(teacher.getTeacherName());
    }
    @Test
    public void When_Get_Teacher_Id_Should_Return_Teacher() throws StudentPortalException {
        Mockito.when(teacherRepo.getOne(324L)).thenReturn(teacher);
        Teacher result= teacherService.getById(324L);
        assertThat(result.getId()).isSameAs(teacher.getId());
    }
    @Test
    public void When_getAll_Teacher_Should_Return_TeacherList() throws StudentPortalException {
        Mockito.when(teacherRepo.findAll()).thenReturn(teacherList);
        List<Teacher> result= teacherService.getAll();
        assertThat(result.get(0).getId()).isSameAs(teacher.getId());
    }
}

