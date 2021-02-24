package com.vira.studentportal.service;


import com.studentportal.exception.StudentPortalException;
import com.studentportal.faculty.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(MockitoJUnitRunner.class)
public class FacultyServiceTest {

    FacultyServiceImpl facultyService;
    @Mock
    FacultyRepo facultyRepo;

    Faculty faculty;
    List<Faculty> facultyList;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        facultyService = new FacultyServiceImpl(facultyRepo, FacultyMapper.INSTANCE);
        facultyList = new ArrayList<>();
        faculty = new Faculty();
        faculty.setFacultyName("TEST");
        faculty.setId(53L);
        facultyList.add(faculty);
    }
    @Test
    public void When_Get_Faculty_Id_Should_Return_Faculty() throws StudentPortalException {
        when(facultyRepo.getOne(anyLong())).thenReturn(faculty);
        FacultyDto result = facultyService.getById(faculty.getId());
        assertThat(result.getFacultyName()).isSameAs(faculty.getFacultyName());
    }
    @Test
    public void When_Save_Faculty_Should_Return_Faculty() throws StudentPortalException {
        Mockito.when(facultyRepo.getOne(faculty.getId())).thenReturn(faculty);
        FacultyDto result = facultyService.getById(faculty.getId());
        assertThat(result.getFacultyName()).isSameAs(faculty.getFacultyName());
    }
    @Test
    public void When_getAll_Faculty_Should_Return_FaculyList() throws StudentPortalException {
        Mockito.when(facultyRepo.findAll()).thenReturn(facultyList);
        List<FacultyDto> result= facultyService.getAll();
        assertThat(result.get(0).getFacultyName()).isSameAs(faculty.getFacultyName());
    }
}
