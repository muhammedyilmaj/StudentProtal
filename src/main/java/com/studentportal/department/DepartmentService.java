package com.studentportal.department;
import com.studentportal.exception.StudentPortalException;
import java.util.List;

public interface DepartmentService {
    Department getById(Long id) throws StudentPortalException;
    List<Department> getAll() throws StudentPortalException;
    Department save(Department department) throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
    Department getByName(String departmentName) throws StudentPortalException, StudentPortalException;
}
