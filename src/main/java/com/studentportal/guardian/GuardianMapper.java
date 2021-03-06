package com.studentportal.guardian;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface GuardianMapper {

    GuardianMapper INSTANCE = Mappers.getMapper(GuardianMapper.class);

    GuardianDto guardianToGuardianDto(Guardian faculty);
    Guardian guardianDtoToGuardian(GuardianDto guardianDto);
}
