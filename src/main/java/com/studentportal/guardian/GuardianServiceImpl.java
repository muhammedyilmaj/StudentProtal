package com.studentportal.guardian;

import com.studentportal.exception.StudentPortalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuardianServiceImpl implements GuardianService {
    private GuardianRepo guardianRepo;
    public GuardianServiceImpl(GuardianRepo guardianRepo) {
        this.guardianRepo=guardianRepo;
    }
    @Override
    public Guardian getById(Long id) throws StudentPortalException {
        try{
            return guardianRepo.getOne(id);
        }catch (Exception e) {
            throw new StudentPortalException("Problem occurs in getById method on GuardianServiceImpl", e);
        }
    }
    @Override
    public List<Guardian> getAll() throws StudentPortalException {
        try {
         return guardianRepo.findAll();
        }catch (Exception e) {
            throw new StudentPortalException("Problem occurs in getAll method on GuardianServiceImpl", e);
        }
    }
    @Override
    public Guardian add(Guardian guardian) throws StudentPortalException {
        try {
            return guardianRepo.save(guardian);
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