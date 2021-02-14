package com.studentportal.lesson;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    LessonDto lessonToLessonDto(Lesson lesson);
    Lesson lessonDtoToLesson(LessonDto lessonDto);

}
