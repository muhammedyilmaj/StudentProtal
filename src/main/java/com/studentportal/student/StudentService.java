package com.studentportal.student;

import com.studentportal.exception.StudentPortalException;
import java.util.List;

public interface StudentService {
    Student getById(Long id) throws StudentPortalException;
    List<Student> getAll() throws StudentPortalException;
    Student save(Student student) throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
}
