package com.vira.studentportal.controller;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.lesson.Lesson;
import com.studentportal.lesson.LessonController;
import com.studentportal.lesson.LessonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LessonControllerTest {
    @Mock
    LessonServiceImpl lessonService;
    @InjectMocks
    LessonController lessonController;
    @Before
    public void setup() {
        lesson.setId(34L);
        lesson.setLessonName("kimya");
    }
    Lesson lesson = new Lesson();
    @Test
    public void Add_Lesson() throws StudentPortalException {
        Mockito.when(lessonService.save(Mockito.any(Lesson.class))).thenReturn(lesson);
        assertThat(lessonController.add(lesson).getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void Get_Lesson_By_Lesson_Id() throws StudentPortalException {
        Mockito.when(lessonService.getById(Mockito.any(Long.class))).thenReturn(lesson);
        assertThat(lessonController.getById(lesson.getId()).getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void Delete_Lesson_By_Lesson_Id() throws StudentPortalException {
        Mockito.when(lessonService.delete(Mockito.any(Long.class))).thenReturn(true);
        assertThat(lessonController.delete(lesson.getId()).getStatusCodeValue()).isEqualTo(200);
    }
}
