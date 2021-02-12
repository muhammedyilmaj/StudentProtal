package com.studentportal.department;

import com.studentportal.faculty.FacultyDto;
import com.studentportal.teacher.Teacher;
import com.studentportal.teacher.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto departmentToDepartmentDto(Department department);
}
