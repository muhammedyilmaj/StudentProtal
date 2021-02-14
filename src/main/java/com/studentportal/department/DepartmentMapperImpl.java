package com.studentportal.department;

import com.studentportal.teacher.Teacher;
import com.studentportal.teacher.TeacherDto;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto departmentToDepartmentDto(Department department) {
        return (DepartmentDto) converter(department);
    }

    @Override
    public Department departmentDtoToDepartment(DepartmentDto departmentDto) {
        return (Department) converter(departmentDto);
    }

    private Object converter(Object object) {

        if (object instanceof Department) {
            DepartmentDto departmentDto= new DepartmentDto();
            departmentDto.setId(((Department) object).getId());
            departmentDto.setLessons(((Department) object).getLessons());
            departmentDto.setStudents(((Department) object).getStudents());
            departmentDto.setFaculty(((Department) object).getFaculty());
            departmentDto.setDepartmentName(((Department) object).getDepartmentName());
            departmentDto.setDepartmentType(((Department) object).getDepartmentType());
            return departmentDto;
        }
        else if (object instanceof DepartmentDto) {
            Department department = new Department();
            department.setId(((DepartmentDto) object).getId());
            department.setLessons(((DepartmentDto) object).getLessons());
            department.setStudents(((DepartmentDto) object).getStudents());
            department.setFaculty(((DepartmentDto) object).getFaculty());
            department.setDepartmentName(((DepartmentDto) object).getDepartmentName());
            department.setDepartmentType(((DepartmentDto) object).getDepartmentType());
            return department;
        }
        else {
            return null;
        }
    }


}
