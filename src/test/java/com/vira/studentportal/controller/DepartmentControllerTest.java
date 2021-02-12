package com.vira.studentportal.controller;

import com.studentportal.department.*;
import com.studentportal.exception.StudentPortalException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentControllerTest {

    @Mock
    DepartmentServiceImpl departmentService;
    @InjectMocks
    DepartmentController departmentController;
    Department department = new Department();
    DepartmentDto departmentDto = new DepartmentDto();
    @Before
    public void setup(){
        department.setDepartmentName("DENEME");
        department.setDepartmentType("MASTER");
        department.setId(324L);
        departmentDto.setDepartmentName("DENEME");
        departmentDto.setDepartmentType("MASTER");
        departmentDto.setId(324L);
    }
    @Test
    public void Add_Department() throws StudentPortalException {
        Mockito.when(departmentService.save(Mockito.any(Department.class))).thenReturn(departmentDto);
        assertThat(departmentController.save(department).getStatusCodeValue()).isEqualTo(201);
    }
    @Test
    public void Get_Department_By_Department_Id() throws StudentPortalException {
        Mockito.when(departmentService.getById(Mockito.any(Long.class))).thenReturn(departmentDto);
        assertThat(departmentController.getById(324L).getStatusCodeValue()).isEqualTo(200);
    }
    @Test
    public void Get_Department_By_Department_Name() throws StudentPortalException {
        Mockito.when(departmentService.getByName(Mockito.any(String.class))).thenReturn(departmentDto);
        assertThat(departmentController.getByName(department.getDepartmentName()).getStatusCodeValue()).isEqualTo(200);
    }
    @Test
    public void Delete_Department_By_Department_ID() throws StudentPortalException {
        Mockito.when(departmentService.delete(Mockito.any(Long.class))).thenReturn(true);
        assertThat(departmentController.delete(department.getId()).getStatusCodeValue()).isEqualTo(200);
    }
}
