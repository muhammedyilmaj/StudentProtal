package com.vira.studentportal.service;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.teacher.*;
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
public class TeacherServiceImplTest {

    TeacherServiceImpl teacherService;
    @Mock
    TeacherRepo teacherRepo;
    Teacher teacher;
    List<Teacher> teacherList;
    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        teacherService = new TeacherServiceImpl(teacherRepo, TeacherMapper.INSTANCE);
        teacher = new Teacher();
        teacherList = new ArrayList<>();
        teacher.setTeacherName("TEST");
        teacher.setId(345L);
        teacherList.add(teacher);
    }
    @Test
    public void When_Save_Teacher_it_Should_Return_Teacher() throws StudentPortalException {
        when(teacherRepo.save(teacher)).thenReturn(teacher);
        TeacherDto result = teacherService.add(TeacherMapper.INSTANCE.teacherToTeacherDto(teacher));
        assertThat(result.getTeacherName()).isSameAs(teacher.getTeacherName());
    }
    @Test
    public void When_Get_Teacher_Id_Should_Return_Teacher() throws StudentPortalException {
        when(teacherRepo.getOne(anyLong())).thenReturn(teacher);
        TeacherDto result = teacherService.getById(324L);
        assertThat(result.getId()).isSameAs(teacher.getId());
    }
    @Test
    public void When_getAll_Teacher_Should_Return_TeacherList() throws StudentPortalException {
        when(teacherRepo.findAll()).thenReturn(teacherList);
        List<TeacherDto> result = teacherService.getAll();
        assertThat(result.get(0).getId()).isSameAs(teacher.getId());
    }
}

