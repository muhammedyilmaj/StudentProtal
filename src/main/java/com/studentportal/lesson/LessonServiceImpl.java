package com.studentportal.lesson;
import com.studentportal.exception.StudentPortalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    private LessonMapperImpl lessonMapper;
    private LessonRepo lessonRepo;

    public LessonServiceImpl(LessonMapperImpl lessonMapper, LessonRepo lessonRepo) {
        this.lessonMapper = lessonMapper;
        this.lessonRepo = lessonRepo;
    }

    @Override
    public LessonDto getById(Long id) throws StudentPortalException {
        try {
            return lessonMapper.lessonToLessonDto(lessonRepo.getOne(id));
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getById method on LessonServiceImpl",e);
        }
    }
    @Override
    public List<LessonDto> getAll() throws StudentPortalException {
        try{
            return lessonRepo.findAll().stream().map(lessonMapper::lessonToLessonDto).collect(Collectors.toList());
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getAll method on LessonServiceImpl",e);
        }
    }
    @Override
    public LessonDto save(Lesson lesson) throws StudentPortalException {
        try {
            return lessonMapper.lessonToLessonDto(lessonRepo.save(lesson));
        } catch (Exception e){
        throw new StudentPortalException("Problem occurs in getAll method on LessonServiceImpl",e);
    }
    }
    @Override
    public boolean delete(Long id) throws StudentPortalException {
       try {
           Lesson lesson=lessonRepo.getOne(id);
           lessonRepo.delete(lesson);
          return !lessonRepo.getOne(id).getId().equals(id);
       }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getAll method on LessonServiceImpl",e);
        }
    }

}

