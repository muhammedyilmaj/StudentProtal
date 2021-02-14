package com.studentportal.guardian;

import com.studentportal.exception.StudentPortalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuardianServiceImpl implements GuardianService {

    private GuardianMapperImpl guardianMapper;
    private GuardianRepo guardianRepo;

    public GuardianServiceImpl(GuardianMapperImpl guardianMapper, GuardianRepo guardianRepo) {
        this.guardianMapper = guardianMapper;
        this.guardianRepo = guardianRepo;
    }

    @Override
    public GuardianDto getById(Long id) throws StudentPortalException {
        try{
            return guardianMapper.guardianToGuardianDto(guardianRepo.getOne(id));
        }catch (Exception e) {
            throw new StudentPortalException("Problem occurs in getById method on GuardianServiceImpl", e);
        }
    }
    @Override
    public List<GuardianDto> getAll() throws StudentPortalException {
        try {
         return guardianRepo.findAll().stream().map(guardianMapper::guardianToGuardianDto).collect(Collectors.toList());
        }catch (Exception e) {
            throw new StudentPortalException("Problem occurs in getAll method on GuardianServiceImpl", e);
        }
    }
    @Override
    public GuardianDto add(GuardianDto guardianDto) throws StudentPortalException {
        try {
            Guardian guardian = guardianMapper.guardianDtoToGuardian(guardianDto);
            return guardianMapper.guardianToGuardianDto(guardianRepo.save(guardian));
        } catch (Exception e) {
            throw new StudentPortalException("Problem occurs in add method on GuardianServiceImpl", e);
        }
    }
    @Override
    public boolean delete(Long id) throws StudentPortalException {
        try {
            Guardian guardian =guardianRepo.getOne(id);
            guardianRepo.delete(guardian);
            return !guardianRepo.getOne(id).getId().equals(id);
        }catch (Exception e) {
            throw new StudentPortalException("Problem occurs in delete method on GuardianServiceImpl", e);
        }
    }

}