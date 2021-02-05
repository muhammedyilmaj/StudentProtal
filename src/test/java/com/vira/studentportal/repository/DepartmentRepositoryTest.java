package com.vira.studentportal.repository;

import com.studentportal.department.Department;
import com.studentportal.department.DepartmentRepo;
import com.studentportal.faculty.Faculty;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DepartmentRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Resource
    DepartmentRepo departmentRepo;

    Department department;
    List<Department> departmentList;
    Faculty faculty;
    @Before
    public void setup(){
        department = new Department();
        departmentList = new ArrayList<>();
        faculty = new Faculty();
        department.setDepartmentName("Mock");
        department.setDepartmentType("MASTER");
        faculty.setFacultyName("deneme");
        departmentList.add(department);
        faculty = testEntityManager.persistAndFlush(faculty);
        department.setFaculty(faculty);
        faculty.setDepartment(departmentList);
    }
    @Test
    public void ADD_AND_GET_DEPARTMENT_BY_ID(){
        department=testEntityManager.persistAndFlush(department);
        assertThat(departmentRepo.getOne(department.getId()).getDepartmentName()).isEqualTo(department.getDepartmentName());

    }
    @Test
    public void GET_DEPARTMENT_BY_DEPARTMENT_NAME(){
        department = testEntityManager.persistAndFlush(department);
        assertThat(departmentRepo.getDepartmentByDepartmentName(department.getDepartmentName()).getDepartmentName()).isEqualTo(department.getDepartmentName());
    }

}
