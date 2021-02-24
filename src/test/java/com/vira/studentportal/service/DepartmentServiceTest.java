package com.vira.studentportal.service;

import com.studentportal.department.*;
import com.studentportal.exception.StudentPortalException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class DepartmentServiceTest {

    DepartmentServiceImpl departmentServiceImpl;
    @Mock
    DepartmentRepo departmentRepo;

    List<Department> departmentList;
    Department department;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        departmentServiceImpl = new DepartmentServiceImpl(departmentRepo, DepartmentMapper.INSTANCE);
        department = new Department();
        departmentList = new ArrayList<>();
        department.setDepartmentType("TEST");
        department.setDepartmentName("TEST2");
        departmentList.add(department);
    }

    @Test
    public void When_Get_Department_Id_Should_Return_Department() throws StudentPortalException {

        when(departmentRepo.getOne(anyLong())).thenReturn(department);
        DepartmentDto result = departmentServiceImpl.getById(324L);
        assertThat(result.getDepartmentName()).isSameAs(department.getDepartmentName());
    }
    @Test
    public void When_Save_Department_Should_Return_Department() throws StudentPortalException {
        when(departmentRepo.save(department)).thenReturn(department);
        DepartmentDto result = departmentServiceImpl.save(DepartmentMapper.INSTANCE.departmentToDepartmentDto(department));
        assertThat(result.getDepartmentType()).isSameAs(department.getDepartmentType());
    }
    @Test
    public void When_getAll_Department_Should_Return_DepartmnetList() throws StudentPortalException {
        Mockito.when(departmentRepo.findAll()).thenReturn(departmentList);
        List<DepartmentDto> result = departmentServiceImpl.getAll();
        assertThat(result.get(0).getDepartmentType()).isSameAs(department.getDepartmentType());
    }

}
