package com.vira.studentportal.controller;

import com.studentportal.department.Department;
import com.studentportal.department.DepartmentDto;
import com.studentportal.exception.StudentPortalException;
import com.studentportal.faculty.*;
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
public class FacultyControllerTest {

    @Mock
    FacultyServiceImpl facultyService;
    @InjectMocks
    FacultyController facultyController;
    @Before
    public void setup(){
        faculty = new Faculty();
        department = new Department();
        departmentList = new ArrayList<>();
        department.setDepartmentName("Mock");
        department.setDepartmentType("MASTER");
        departmentList.add(department);
        faculty.setFacultyName("Mock");
        faculty.setId(34L);
        faculty.setDepartment(departmentList);

        facultyDto = new FacultyDto();
        departmentDto = new DepartmentDto();
        departmentListDto = new ArrayList<>();
        departmentDto.setDepartmentName("Mock");
        departmentDto.setDepartmentType("MASTER");
        departmentListDto.add(departmentDto);
        facultyDto.setFacultyName("Mock");
        facultyDto.setId(34L);
        facultyDto.setDepartment(departmentList);
    }
    Faculty faculty;
    Department department;
    List<Department> departmentList;

    FacultyDto facultyDto;
    DepartmentDto departmentDto;
    List<DepartmentDto> departmentListDto;
    @Test
    public void Add_Faculty() throws StudentPortalException {
        Mockito.when(facultyService.add(Mockito.any(FacultyDto.class))).thenReturn(facultyDto);
        assertThat(facultyController.add(facultyDto).getStatusCodeValue()).isEqualTo(201);
    }
    @Test
    public void Get_Faculty_By_Faculty_Id() throws StudentPortalException {
        Mockito.when(facultyService.getById(Mockito.any(Long.class))).thenReturn(facultyDto);
        assertThat(facultyController.getById(faculty.getId()).getStatusCodeValue()).isEqualTo(200);
    }
    @Test
    public void Delete_Faculty_By_Faculty_Id() throws StudentPortalException {
        Mockito.when(facultyService.delete(Mockito.any(Long.class))).thenReturn(true);
        assertThat(facultyController.delete(faculty.getId()).getStatusCodeValue()).isEqualTo(200);
    }

}
