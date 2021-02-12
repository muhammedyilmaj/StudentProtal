package com.vira.studentportal.repository;

import com.studentportal.department.Department;
import com.studentportal.faculty.Faculty;
import com.studentportal.faculty.FacultyRepo;
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
public class FacultyRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Resource
    FacultyRepo facultyRepo;
    @Before
    public void setup(){
        departmentList = new ArrayList<>();
        department = new Department();
        faculty = new Faculty();
        department.setDepartmentName("Mock");
        department.setDepartmentType("MASTER");
        departmentList.add(department);
        faculty.setFacultyName("Mock");
        faculty.setDepartment(departmentList);
    }
    List<Department> departmentList;
    Department department;
    Faculty faculty;

    @Test
    public void ADD_AND_GET_FACULTY_BY_ID(){
        faculty=entityManager.persistAndFlush(faculty);
        assertThat(facultyRepo.getOne(faculty.getId()).getId()).isEqualTo(faculty.getId());
    }
}
