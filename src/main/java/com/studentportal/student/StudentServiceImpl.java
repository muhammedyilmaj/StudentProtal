package com.studentportal.student;

import com.studentportal.exception.StudentPortalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;
    private StudentRepo studentRepo;

    public StudentServiceImpl( StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
        this.studentRepo = studentRepo;
    }

    @Override
    public StudentDto getById(Long id) throws StudentPortalException {
        try {
        return studentMapper.studentToStudentDto(studentRepo.getOne(id));
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getById method on StudentServiceImpl",e);
        }
    }
    @Override
    public StudentDto save(StudentDto studentDto) throws StudentPortalException {
        try {
            Student student = studentMapper.studentDtoToStudent(studentDto);
            return studentMapper.studentToStudentDto(studentRepo.save(student));
        }
        catch (Exception e){
            throw new StudentPortalException("Problem occurs in save method on StudentServiceImpl",e);
        }

    }
    @Override
    public List<StudentDto> getAll() throws StudentPortalException {
        try {
            return studentRepo.findAll().stream().map(studentMapper::studentToStudentDto).collect(Collectors.toList());
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
