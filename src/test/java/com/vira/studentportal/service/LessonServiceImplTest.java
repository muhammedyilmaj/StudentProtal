package com.vira.studentportal.service;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.lesson.Lesson;
import com.studentportal.lesson.LessonRepo;
import com.studentportal.lesson.LessonServiceImpl;
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
public class LessonServiceImplTest {
    @InjectMocks
    LessonServiceImpl lessonService;
    @Mock
    LessonRepo lessonRepo;
    Lesson lesson;
    List<Lesson> lessonList;

    @Before
    public void setup(){
        lessonList= new ArrayList<>();
        lesson= new Lesson();
        lesson.setLessonName("TEST");
        lesson.setId(345L);
        lessonList.add(lesson);
    }
    @Test
    public void When_Save_Lesson_it_Should_Return_Lesson() throws StudentPortalException {
        Mockito.when(lessonRepo.getOne(lesson.getId())).thenReturn(lesson);
        Lesson result= lessonService.getById(lesson.getId());
        assertThat(result.getLessonName()).isSameAs(lesson.getLessonName());
    }
    @Test
    public void When_Get_Lesson_Id_Should_Return_Lesson() throws StudentPortalException {
        Mockito.when(lessonRepo.getOne(324L)).thenReturn(lesson);
        Lesson result= lessonService.getById(324L);
        assertThat(result.getId()).isSameAs(lesson.getId());
    }
    @Test
    public void When_getAll_Lesson_Should_Return_LessonList() throws StudentPortalException {
        Mockito.when(lessonRepo.findAll()).thenReturn(lessonList);
        List<Lesson> result= lessonService.getAll();
        assertThat(result.get(0).getId()).isSameAs(lesson.getId());
    }
}