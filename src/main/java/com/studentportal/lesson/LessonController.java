package com.studentportal.lesson;
import com.studentportal.exception.StudentPortalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("lessons")
public class LessonController {
    private LessonServiceImpl lessonServiceImpl;
    public LessonController(LessonServiceImpl lessonServiceImpl){
        this.lessonServiceImpl = lessonServiceImpl;
    }
    @GetMapping("/{lessonId}")
    public ResponseEntity<LessonDto> getById(@PathVariable("lessonId") Long  id) throws StudentPortalException {
        LessonDto lesson = lessonServiceImpl.getById(id);
        if(lesson.getId().equals(id)){
            return new ResponseEntity<>(lesson,HttpStatus.OK);
        }else
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<LessonDto>> getAll() throws StudentPortalException {
        List<LessonDto> lessons = lessonServiceImpl.getAll();
        if(lessons.size()>0){
            return new ResponseEntity<>(lessons,HttpStatus.OK);
        }else
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<LessonDto> add(@RequestBody Lesson lesson) throws StudentPortalException {
        LessonDto createdLesson = lessonServiceImpl.save(lesson);
        if(createdLesson.getLessonName().equals(lesson.getLessonName())) {
            return new ResponseEntity<>(createdLesson,HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id) throws StudentPortalException {
        boolean result= lessonServiceImpl.delete(id);
        if(result){
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
