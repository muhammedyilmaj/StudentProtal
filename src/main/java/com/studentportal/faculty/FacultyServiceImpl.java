package com.studentportal.faculty;

import com.studentportal.exception.StudentPortalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private FacultyMapper facultyMapper;
    private FacultyRepo facultyRepo;

    public FacultyServiceImpl(FacultyRepo facultyRepo, FacultyMapper facultyMapper) {

        this.facultyRepo = facultyRepo;
        this.facultyMapper = facultyMapper;
    }

    @Override
    public FacultyDto getById(Long id) throws StudentPortalException {
        try {
            return facultyMapper.facultyToFacultyDto(facultyRepo.getOne(id));
        } catch (Exception e) {
            throw new StudentPortalException("Problem occurs in getById method on FacultyServiceImpl", e);
        }
    }

    @Override
    public List<FacultyDto> getAll() throws StudentPortalException {
        try {
            return facultyRepo.findAll().stream().map(facultyMapper::facultyToFacultyDto).collect(Collectors.toList());
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
    public FacultyDto add(Faculty faculty) throws StudentPortalException {
        try {
           return facultyMapper.facultyToFacultyDto(facultyRepo.save(faculty));
        } catch (Exception e) {
            throw new StudentPortalException("Problem occurs in add method on FacultyServiceImpl", e);
        } }
}