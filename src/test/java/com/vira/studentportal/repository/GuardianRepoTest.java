package com.vira.studentportal.repository;

import com.studentportal.guardian.Guardian;
import com.studentportal.guardian.GuardianRepo;
import com.studentportal.student.Student;
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
public class GuardianRepoTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Resource
    GuardianRepo guardianRepo;
    @Before
    public void setup(){
        student.setName("muhammed");
        student.setGrade("son");
        studentList.add(student);
        guardian.setStudents(studentList);
        guardian.setName("Mock");

    }
    Guardian guardian = new Guardian();
    Student student=new Student();
    List<Student> studentList=new ArrayList<>();
    @Test
    public void ADD_AND_GET_STUDENT_GUARDIAN_BY_ID(){
        guardian =testEntityManager.persistAndFlush(guardian);
        assertThat(guardianRepo.getOne(guardian.getId()).getId()).isEqualTo(guardian.getId());
    }
}
