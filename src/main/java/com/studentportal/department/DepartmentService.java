package com.studentportal.department;
import com.studentportal.exception.StudentPortalException;
import java.util.List;

public interface DepartmentService {
    DepartmentDto getById(Long id) throws StudentPortalException;
    List<DepartmentDto> getAll() throws StudentPortalException;
    DepartmentDto save(Department department) throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
    DepartmentDto getByName(String departmentName) throws StudentPortalException, StudentPortalException;
}
