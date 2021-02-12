package com.studentportal.lesson;

import org.springframework.stereotype.Component;

@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonDto lessonToLessonDto(Lesson lesson) {
        if( lesson == null ) {
            return null;
        }
        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(lesson.getId());
        lessonDto.setDepartment(lesson.getDepartment());
        lessonDto.setLessonClass(lesson.getLessonClass());
        lessonDto.setLessonName(lesson.getLessonName());
        lessonDto.setTeachers(lesson.getTeachers());
        return lessonDto;
    }

}
