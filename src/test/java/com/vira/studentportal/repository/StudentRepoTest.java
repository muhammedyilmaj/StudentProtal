package com.vira.studentportal.repository;

import com.studentportal.student.Student;
import com.studentportal.student.StudentRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepoTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Resource
    StudentRepo studentRepo;
    @Before
    public void setup(){
        student.setGrade("ne bilem");
        student.setName("ragors");

    }
    Student student=new Student();
    @Test
    public void ADD_AND_GET_STUDENT_BY_ID(){
        student=testEntityManager.persistAndFlush(student);
        assertThat(studentRepo.getOne(student.getId()).getId()).isEqualTo(student.getId());

    }

}
