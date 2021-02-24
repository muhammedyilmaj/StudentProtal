package com.studentportal.department;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDto departmentToDepartmentDto(Department department);
    Department departmentDtoToDepartment(DepartmentDto departmentDto);
}
