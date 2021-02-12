package com.studentportal.faculty;

import com.studentportal.exception.StudentPortalException;

import java.util.List;

public interface FacultyService {
    FacultyDto getById(Long id) throws StudentPortalException, StudentPortalException;
    FacultyDto add(Faculty faculty) throws StudentPortalException;
    List<FacultyDto> getAll() throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
}
