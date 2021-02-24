package com.studentportal.lesson;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    LessonDto lessonToLessonDto(Lesson lesson);
    Lesson lessonDtoToLesson(LessonDto lessonDto);

}
