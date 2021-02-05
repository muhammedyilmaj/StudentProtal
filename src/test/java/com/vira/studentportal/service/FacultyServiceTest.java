package com.vira.studentportal.service;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.faculty.Faculty;
import com.studentportal.faculty.FacultyDto;
import com.studentportal.faculty.FacultyRepo;
import com.studentportal.faculty.FacultyServiceImpl;
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
public class FacultyServiceTest {
    @InjectMocks
    FacultyServiceImpl facultyService;
    @Mock
    FacultyRepo facultyRepo;

    Faculty faculty;
    List<Faculty> facultyList;

    @Before
    public void setup(){
        facultyList = new ArrayList<>();
        faculty = new Faculty();
        faculty.setFacultyName("TEST");
        faculty.setId(53L);
        facultyList.add(faculty);
    }
    @Test
    public void When_Faculy_Should_Return_Faculy() throws StudentPortalException {
        Mockito.when(facultyRepo.getOne(faculty.getId())).thenReturn(faculty);
        FacultyDto result = facultyService.getById(faculty.getId());
        assertThat(result.getFacultyName()).isSameAs(faculty.getFacultyName());
    }
    @Test
    public void When_Save_Faculty_it_Should_Return_Faculty() throws StudentPortalException {
        Mockito.when(facultyRepo.getOne(faculty.getId())).thenReturn(faculty);
        FacultyDto result = facultyService.getById(faculty.getId());
        assertThat(result.getFacultyName()).isSameAs(faculty.getFacultyName());
    }
    @Test
    public void When_getAll_Faculy_Should_Return_FaculyList() throws StudentPortalException {
        Mockito.when(facultyRepo.findAll()).thenReturn(facultyList);
        List<FacultyDto> result= facultyService.getAll();
        assertThat(result.get(0).getFacultyName()).isSameAs(faculty.getFacultyName());
    }
}
