package com.studentportal.teacher;

import com.studentportal.exception.StudentPortalException;

import java.util.List;

public interface TeacherService {
    Teacher getById(Long id) throws StudentPortalException;
    List<Teacher> getAll() throws StudentPortalException;
    Teacher add(Teacher teacher) throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
}
