package com.studentportal.student;

import com.studentportal.exception.StudentPortalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;
    public StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }
    @Override
    public Student getById(Long id) throws StudentPortalException {
        try {
        return studentRepo.getOne(id);
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getById method on StudentServiceImpl",e);
        }
    }
    @Override
    public Student save(Student student) throws StudentPortalException {
        try {
         return studentRepo.save(student);}catch (Exception e){
            throw new StudentPortalException("Problem occurs in save method on StudentServiceImpl",e);
        }

    }
    @Override
    public List<Student> getAll() throws StudentPortalException {
        try {
            return studentRepo.findAll();
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getAll method on StudentServiceImpl",e);
        }
    }
    @Override
    public boolean delete(Long id) throws StudentPortalException {
        try {
        Student student= studentRepo.getOne(id);
        studentRepo.delete(student);
            return !studentRepo.getOne(id).getId().equals(id);
        }
        catch (Exception e){
            throw new StudentPortalException("Problem occurs in delete method on StudentServiceImpl",e);
        }
    }

}
