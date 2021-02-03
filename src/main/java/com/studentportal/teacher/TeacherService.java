package com.studentportal.teacher;

import com.studentportal.exception.StudentPortalException;

import java.util.List;

public interface TeacherService {
    TeacherDto getById(Long id) throws StudentPortalException;
    List<TeacherDto> getAll() throws StudentPortalException;
    TeacherDto add(Teacher teacher) throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
}
