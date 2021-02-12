package com.studentportal.department;

import com.studentportal.teacher.Teacher;
import com.studentportal.teacher.TeacherDto;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto departmentToDepartmentDto(Department department) {
        if( department == null ) {
            return null;
        }
        DepartmentDto departmentDto= new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setLessons(department.getLessons());
        departmentDto.setStudents(department.getStudents());
        departmentDto.setFaculty(department.getFaculty());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentType(department.getDepartmentType());
        return departmentDto;
    }

}
