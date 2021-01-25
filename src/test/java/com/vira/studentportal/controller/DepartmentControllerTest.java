package com.vira.studentportal.controller;


import com.studentportal.department.Department;
import com.studentportal.department.DepartmentController;
import com.studentportal.department.DepartmentServiceImpl;
import com.studentportal.exception.StudentPortalException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentControllerTest {
    @Mock
    DepartmentServiceImpl departmentService;
    @InjectMocks
    DepartmentController departmentController;
    Department department=new Department();
    @Before
    public void setup(){
        department.setDepartmentName("DENEME");
        department.setDepartmentType("MASTER");
        department.setId(324L);
    }
    @Test
    public void Add_Department() throws StudentPortalException {
        Mockito.when(departmentService.save(Mockito.any(Department.class))).thenReturn(department);
        assertThat(departmentController.save(department).getStatusCodeValue()).isEqualTo(201);
    }
    @Test
    public void Get_Department_By_Department_Id() throws StudentPortalException {
        Mockito.when(departmentService.getById(Mockito.any(Long.class))).thenReturn(department);
        assertThat(departmentController.getById(324L).getStatusCodeValue()).isEqualTo(200);
    }
    @Test
    public void Get_Department_By_Department_Name() throws StudentPortalException {
        Mockito.when(departmentService.getByName(Mockito.any(String.class))).thenReturn(department);
        assertThat(departmentController.getByName(department.getDepartmentName()).getStatusCodeValue()).isEqualTo(200);
    }
    @Test
    public void Delete_Department_By_Department_ID() throws StudentPortalException {
        Mockito.when(departmentService.delete(Mockito.any(Long.class))).thenReturn(true);
        assertThat(departmentController.delete(department.getId()).getStatusCodeValue()).isEqualTo(200);
    }
}
