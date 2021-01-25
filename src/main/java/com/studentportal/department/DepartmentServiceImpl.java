package com.studentportal.department;

import java.util.List;

import com.studentportal.exception.StudentPortalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepo departmentRepo;
    public DepartmentServiceImpl(DepartmentRepo departmentRepo){
        this.departmentRepo=departmentRepo;
    }
    @Override
    public Department getById(Long id) throws StudentPortalException {
        try {
        return departmentRepo.getOne(id);
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getAll method on DepartmentServiceImpl",e);
        }
    }
    @Override
    public List<Department> getAll() throws StudentPortalException {
        try{
            return departmentRepo.findAll();
        }catch (Exception e){
            throw new StudentPortalException("Exception occur occurs in getAll method on DepartmentServiceImpl",e);
        }
    }
    @Override
    public Department save(Department department) throws StudentPortalException {
        try {
           return departmentRepo.save(department);
        } catch (Exception e){
            throw new StudentPortalException("Problem occurs in save method on DepartmentServiceImpl",e);
    }
    }
    @Override
    public boolean delete(Long id) throws StudentPortalException {
        try {
            Department department = departmentRepo.getOne(id);
            departmentRepo.delete(department);
            return !departmentRepo.getOne(id).getId().equals(id);
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in delete method on DepartmentServiceImpl",e);
        }
    }
    @Override
    public Department getByName(String departmentName) throws StudentPortalException {
        try {
            return departmentRepo.getDepartmentByDepartmentName(departmentName);
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getByName method on DepartmentServiceImpl",e);
        }
    }
}
