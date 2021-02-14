package com.studentportal.guardian;

import com.studentportal.faculty.Faculty;
import com.studentportal.faculty.FacultyDto;
import org.springframework.stereotype.Component;

@Component
public class GuardianMapperImpl implements GuardianMapper {

    @Override
    public GuardianDto guardianToGuardianDto(Guardian guardian) {
        return (GuardianDto) converter(guardian);
    }

    @Override
    public Guardian guardianDtoToGuardian(GuardianDto guardianDto) {
        return (Guardian) converter(guardianDto);
    }
    private Object converter(Object object) {

        if (object instanceof Guardian) {
            GuardianDto guardianDto = new GuardianDto();
            guardianDto.setId(((Guardian) object).getId());
            guardianDto.setName(((Guardian) object).getName());
            guardianDto.setStudents(((Guardian) object).getStudents());
            return guardianDto;
        }
        else if (object instanceof GuardianDto) {
            Guardian guardian = new Guardian();
            guardian.setId(((GuardianDto) object).getId());
            guardian.setName(((GuardianDto) object).getName());
            guardian.setStudents(((GuardianDto) object).getStudents());
            return guardian;
        }
        else {
            return null;
        }
    }
}
