package com.studentportal.faculty;

import com.studentportal.exception.StudentPortalException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacultyServiceImpl implements FacultyService {
    private FacultyRepo facultyRepo;

    public FacultyServiceImpl(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    @Override
    public Faculty getById(Long id) throws StudentPortalException {
        try {
            return facultyRepo.getOne(id);
        } catch (Exception e) {
            throw new StudentPortalException("Problem occurs in getById method on FacultyServiceImpl", e);
        }
    }

    @Override
    public List<Faculty> getAll() throws StudentPortalException {
        try {
            return facultyRepo.findAll();
        } catch (Exception e) {
            throw new StudentPortalException("Problem occurs in getAll method on FacultyServiceImpl", e);
        }
    }

    @Override
    public boolean delete(Long id) throws StudentPortalException {
        try {
            Faculty faculty = facultyRepo.getOne(id);
            facultyRepo.delete(faculty);
            return !facultyRepo.getOne(id).getId().equals(id);
        } catch (Exception e) {
            throw new StudentPortalException("Problem occurs in delete method on FacultyServiceImpl", e);
        }
    }

    @Override
    public Faculty add(Faculty faculty) throws StudentPortalException {
        try {
           return facultyRepo.save(faculty);
        } catch (Exception e) {
            throw new StudentPortalException("Problem occurs in add method on FacultyServiceImpl", e);
        } }
}