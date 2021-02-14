package com.studentportal.lesson;

import com.studentportal.exception.StudentPortalException;
import java.util.List;

public interface LessonService {
    LessonDto getById(Long id) throws StudentPortalException;
    List<LessonDto> getAll() throws StudentPortalException;
    LessonDto save(LessonDto lesson) throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
}
