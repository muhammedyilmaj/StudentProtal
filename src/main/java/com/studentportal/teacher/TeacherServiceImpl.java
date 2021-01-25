package com.studentportal.teacher;

import com.studentportal.exception.StudentPortalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepo teacherRepo;
    public TeacherServiceImpl(TeacherRepo teacherRepo){
        this.teacherRepo=teacherRepo;
    }
    @Override
    public Teacher getById(Long id) throws StudentPortalException {
        try {
            return teacherRepo.getOne(id);
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getById method on TeacherServiceImpl",e);
        }
    }
    @Override
    public List<Teacher> getAll() throws StudentPortalException {
        try {
            return teacherRepo.findAll();
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getAll method on TeacherServiceImpl",e);
        }
    }
    @Override
    public Teacher add(Teacher teacher) throws StudentPortalException {
        try {
            return teacherRepo.save(teacher);
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in add method on TeacherServiceImpl",e);
        }
    }
    @Override
    public boolean delete(Long id) throws StudentPortalException {
        try {
            Teacher teacher=teacherRepo.getOne(id);
            teacherRepo.delete(teacher);
            return !teacherRepo.getOne(id).getId().equals(id);
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in delete method on TeacherServiceImpl",e);
        }

    }
}
