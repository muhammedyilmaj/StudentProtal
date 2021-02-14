package com.studentportal.lesson;

import com.studentportal.faculty.Faculty;
import com.studentportal.faculty.FacultyDto;
import org.springframework.stereotype.Component;

@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonDto lessonToLessonDto(Lesson lesson) {
        return (LessonDto) converter(lesson);
    }

    @Override
    public Lesson lessonDtoToLesson(LessonDto lessonDto) {
        return (Lesson) converter(lessonDto);
    }

    private Object converter(Object object) {

        if (object instanceof Lesson) {
            LessonDto lessonDto = new LessonDto();
            lessonDto.setId(((Lesson) object).getId());
            lessonDto.setDepartment(((Lesson) object).getDepartment());
            lessonDto.setLessonClass(((Lesson) object).getLessonClass());
            lessonDto.setLessonName(((Lesson) object).getLessonName());
            lessonDto.setTeachers(((Lesson) object).getTeachers());
            return lessonDto;
        }
        else if (object instanceof LessonDto) {
            Lesson lesson = new Lesson();
            lesson.setId(((LessonDto) object).getId());
            lesson.setDepartment(((LessonDto) object).getDepartment());
            lesson.setLessonClass(((LessonDto) object).getLessonClass());
            lesson.setLessonName(((LessonDto) object).getLessonName());
            lesson.setTeachers(((LessonDto) object).getTeachers());
            return lesson;
        }
        else {
            return null;
        }
    }
}
