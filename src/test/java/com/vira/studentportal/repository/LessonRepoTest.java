package com.vira.studentportal.repository;

import com.studentportal.lesson.Lesson;
import com.studentportal.lesson.LessonRepo;
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
public class LessonRepoTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Resource
    LessonRepo lessonRepo;
    @Before
    public void setup(){
        lesson = new Lesson();
        lesson.setLessonName("kimya");
    }
    Lesson lesson;
    @Test
    public void ADD_AND_GET_LESSON_BY_ID(){
        lesson=testEntityManager.persistAndFlush(lesson);
        assertThat(lessonRepo.getOne(lesson.getId()).getId()).isEqualTo(lesson.getId());
    }
}
