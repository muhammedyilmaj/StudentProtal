package com.studentportal.faculty;

import com.studentportal.exception.StudentPortalException;

import java.util.List;

public interface FacultyService {
    Faculty getById(Long id) throws StudentPortalException, StudentPortalException;
    Faculty add(Faculty faculty) throws StudentPortalException;
    List<Faculty> getAll() throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
}
