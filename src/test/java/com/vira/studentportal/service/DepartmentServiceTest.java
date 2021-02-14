package com.vira.studentportal.service;

import com.studentportal.department.*;
import com.studentportal.exception.StudentPortalException;
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
public class DepartmentServiceTest {
    @InjectMocks
    DepartmentServiceImpl departmentServiceImpl;
    @Mock
    DepartmentRepo departmentRepo;
    @Mock
    DepartmentMapperImpl departmentMapper;
    List<Department> departmentList;
    Department department;
    @Before
    public void setup(){
        department = new Department();
        departmentList = new ArrayList<>();
        department.setDepartmentType("TEST");
        department.setDepartmentName("TEST2");
        departmentList.add(department);
    }

    @Test
    public void When_Get_Department_Id_Should_Return_Department() throws StudentPortalException {

        Mockito.when(departmentRepo.getOne(324L)).thenReturn(department);
        DepartmentDto result = departmentServiceImpl.getById(324L);
        assertThat(result.getDepartmentName()).isSameAs(department.getDepartmentName());
    }
    @Test
    public void When_Save_Department_Should_Return_Department() throws StudentPortalException {
        Mockito.when(departmentRepo.save(department)).thenReturn(department);
        DepartmentDto result = departmentServiceImpl.save(departmentMapper.departmentToDepartmentDto(department));
        assertThat(result.getDepartmentType()).isSameAs(department.getDepartmentType());
    }
    @Test
    public void When_getAll_Department_Should_Return_DepartmnetList() throws StudentPortalException {
        Mockito.when(departmentRepo.findAll()).thenReturn(departmentList);
        List<DepartmentDto> result = departmentServiceImpl.getAll();
        assertThat(result.get(0).getDepartmentType()).isSameAs(department.getDepartmentType());
    }

}
