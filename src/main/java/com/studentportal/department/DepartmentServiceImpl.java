package com.studentportal.department;

import java.util.List;
import java.util.stream.Collectors;

import com.studentportal.exception.StudentPortalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentMapperImpl departmentMapper;
    private DepartmentRepo departmentRepo;
    public DepartmentServiceImpl(DepartmentRepo departmentRepo, DepartmentMapperImpl departmentMapper){
        this.departmentRepo = departmentRepo;
        this.departmentMapper = departmentMapper;
    }
    @Override
    public DepartmentDto getById(Long id) throws StudentPortalException {
        try {
            return departmentMapper.departmentToDepartmentDto(departmentRepo.getOne(id));
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getAll method on DepartmentServiceImpl",e);
        }
    }
    @Override
    public List<DepartmentDto> getAll() throws StudentPortalException {
        try{
            return departmentRepo.findAll().stream().map(departmentMapper::departmentToDepartmentDto).collect(Collectors.toList());
        }catch (Exception e){
            throw new StudentPortalException("Exception occur occurs in getAll method on DepartmentServiceImpl",e);
        }
    }
    @Override
    public DepartmentDto save(Department department) throws StudentPortalException {
        try {
           return departmentMapper.departmentToDepartmentDto(departmentRepo.save(department));
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
    public DepartmentDto getByName(String departmentName) throws StudentPortalException {
        try {
            return departmentMapper.departmentToDepartmentDto(departmentRepo.getDepartmentByDepartmentName(departmentName));
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getByName method on DepartmentServiceImpl",e);
        }
    }
}
