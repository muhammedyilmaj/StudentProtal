package com.studentportal.student;
import java.util.List;

import com.studentportal.exception.StudentPortalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentServiceImpl studentServiceImpl;
    public StudentController(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getById(@PathVariable("studentId") Long studentId) throws StudentPortalException {
        StudentDto student= studentServiceImpl.getById(studentId);
        if(student.getId().equals(studentId)){
            return new ResponseEntity<>(student,HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Student student) throws StudentPortalException {
        StudentDto responseStudent=studentServiceImpl.save(student);
        if(responseStudent.getName().equals(student.getName())){
            return new ResponseEntity<>(HttpStatus.CREATED);}
         else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() throws StudentPortalException {
        List<StudentDto> students= studentServiceImpl.getAll();
        if(students.size()>=1){
            return new ResponseEntity<>(students,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> delete(@PathVariable ("studentId") Long studentId) throws StudentPortalException {
        if(studentServiceImpl.delete(studentId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
