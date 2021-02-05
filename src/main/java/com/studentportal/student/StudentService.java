package com.studentportal.student;

import com.studentportal.exception.StudentPortalException;
import java.util.List;

public interface StudentService {
    StudentDto getById(Long id) throws StudentPortalException;
    List<StudentDto> getAll() throws StudentPortalException;
    StudentDto save(Student student) throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
}
