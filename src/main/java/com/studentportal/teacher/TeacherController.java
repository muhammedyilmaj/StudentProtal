package com.studentportal.teacher;
import com.studentportal.exception.StudentPortalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("teachers")
public class TeacherController {
    private TeacherServiceImpl teacherServiceImpl;
    public TeacherController(TeacherServiceImpl teacherServiceImpl){
        this.teacherServiceImpl = teacherServiceImpl;
    }
    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDto> getById(@PathVariable("teacherId") Long id) throws StudentPortalException {
        TeacherDto teacher = teacherServiceImpl.getById(id);
        if(teacher.getId().equals(id)) {
            return  new ResponseEntity<>(teacher, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAll() throws StudentPortalException {
        List<TeacherDto> teachers = teacherServiceImpl.getAll();
        if(teachers.size() >= 1) {
        return new ResponseEntity<>(teachers,HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Teacher teacher) throws StudentPortalException {
        TeacherDto newTeacher = teacherServiceImpl.add(teacher);
        if(newTeacher.getTeacherName().equals(teacher.getTeacherName())){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id) throws StudentPortalException {
        if(teacherServiceImpl.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);}
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
