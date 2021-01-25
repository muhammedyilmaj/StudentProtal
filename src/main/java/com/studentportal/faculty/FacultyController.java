package com.studentportal.faculty;

import com.studentportal.exception.StudentPortalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("faculties")
public class FacultyController {
    private FacultyServiceImpl facultyServiceImpl;
    public FacultyController (FacultyServiceImpl facultyServiceImpl){
        this.facultyServiceImpl = facultyServiceImpl;
    }
    @GetMapping("/{facultyId}")
    public ResponseEntity<Faculty> getById(@PathVariable("facultyId") Long id) throws StudentPortalException {
        Faculty faculty= facultyServiceImpl.getById(id);
        if(faculty.getId().equals(id)){
            return  new ResponseEntity<>(faculty, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<Faculty>> getAll() throws StudentPortalException {
        List<Faculty> faculties= facultyServiceImpl.getAll();
        if(faculties.size()>0){
            return new ResponseEntity<>(faculties,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<Faculty> add(@RequestBody Faculty faculty) throws StudentPortalException {
        Faculty resultfaculty=facultyServiceImpl.add(faculty);
        if(resultfaculty.getFacultyName().equals(faculty.getFacultyName())){
            return new ResponseEntity<>(faculty,HttpStatus.CREATED);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id) throws StudentPortalException {
        if(facultyServiceImpl.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
