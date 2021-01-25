package com.studentportal.lesson;
import com.studentportal.exception.StudentPortalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    private LessonRepo lessonRepo;
    public LessonServiceImpl(LessonRepo lessonRepo){
        this.lessonRepo=lessonRepo;
    }
    @Override
    public Lesson getById(Long id) throws StudentPortalException {
        try {
            return lessonRepo.getOne(id);
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getById method on LessonServiceImpl",e);
        }
    }
    @Override
    public List<Lesson> getAll() throws StudentPortalException {
        try{
        return lessonRepo.findAll();
        }catch (Exception e){
            throw new StudentPortalException("Problem occurs in getAll method on LessonServiceImpl",e);
        }
    }
    @Override
    public Lesson save(Lesson lesson) throws StudentPortalException {
        try{return lessonRepo.save(lesson);}catch (Exception e){
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

