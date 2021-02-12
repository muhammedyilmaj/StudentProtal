package com.vira.studentportal.repository;

import com.studentportal.student.Student;
import com.studentportal.teacher.Teacher;
import com.studentportal.teacher.TeacherRepo;
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
public class TeacherRepoTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Resource
    TeacherRepo teacherRepo;
    @Before
    public void setup(){
        student.setName("adsf");
        student.setGrade("asdfsdf");
        studentList.add(student);
        teacher.setStudents(studentList);
        teacher.setTeacherName("banbala");
    }
    Teacher teacher = new Teacher();
    Student student = new Student();
    List<Student> studentList = new ArrayList<>();
    @Test
    public void ADD_AND_GET_STUDENT_BY_ID(){
        teacher = testEntityManager.persistAndFlush(teacher);
        assertThat(teacherRepo.getOne(teacher.getId()).getId()).isEqualTo(teacher.getId());
    }
}
