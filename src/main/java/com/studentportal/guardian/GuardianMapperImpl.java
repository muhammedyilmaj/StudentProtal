package com.studentportal.guardian;

import com.studentportal.faculty.Faculty;
import com.studentportal.faculty.FacultyDto;
import org.springframework.stereotype.Component;

@Component
public class GuardianMapperImpl implements GuardianMapper {

    @Override
    public GuardianDto guardianToGuardianDto(Guardian guardian) {
        if( guardian == null ) {
            return null;
        }
        GuardianDto guardianDto = new GuardianDto();
        guardianDto.setId(guardian.getId());
        guardianDto.setName(guardian.getName());
        guardianDto.setStudents(guardian.getStudents());
        return guardianDto;
    }

}
