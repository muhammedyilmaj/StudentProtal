package com.studentportal.teacher;

import com.studentportal.exception.StudentPortalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepo teacherRepo;
    private TeacherMapper teacherMapper;
    public TeacherServiceImpl(TeacherRepo teacherRepo, TeacherMapper teacherMapper){
        this.teacherRepo = teacherRepo;
        this.teacherMapper = teacherMapper;
    }
    @Override
    public TeacherDto getById(Long id) throws StudentPortalException {
        try {
            return teacherMapper.teacherToTeacherDto(teacherRepo.getOne(id));
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getById method on TeacherServiceImpl",e);
        }
    }
    @Override
    public List<TeacherDto> getAll() throws StudentPortalException {
        try {
            return teacherRepo.findAll().stream()
                    .map(teacherMapper::teacherToTeacherDto)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getAll method on TeacherServiceImpl",e);
        }
    }
    @Override
    public TeacherDto add(TeacherDto teacherDto) throws StudentPortalException {
        try {
            Teacher teacher = teacherMapper.teacherDtoToTeacher(teacherDto);
            return teacherMapper.teacherToTeacherDto(teacherRepo.save(teacher));
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in add method on TeacherServiceImpl",e);
        }
    }
    @Override
    public boolean delete(Long id) throws StudentPortalException {
        try {
            Teacher teacher = teacherRepo.getOne(id);
            teacherRepo.delete(teacher);
            return !teacherRepo.getOne(id).getId().equals(id);
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in delete method on TeacherServiceImpl",e);
        }

    }
}
