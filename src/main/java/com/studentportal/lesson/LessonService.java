package com.studentportal.lesson;

import com.studentportal.exception.StudentPortalException;
import java.util.List;

public interface LessonService {
    Lesson getById(Long id) throws StudentPortalException;
    List<Lesson> getAll() throws StudentPortalException;
    Lesson save(Lesson lesson) throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
}
