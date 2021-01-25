package com.studentportal.guardian;

import com.studentportal.exception.StudentPortalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("parents")
public class GuardianController {
    private GuardianServiceImpl guardianServiceImpl;
    public GuardianController(GuardianServiceImpl guardianServiceImpl){
        this.guardianServiceImpl = guardianServiceImpl;
    }
    @GetMapping("/{parentId}")
    public ResponseEntity<Guardian> getById(@PathVariable("parentId") Long id) throws StudentPortalException {
        Guardian guardian = guardianServiceImpl.getById(id);
        if(guardian.getId().equals(id)){
            return  new ResponseEntity<>(guardian, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<Guardian>> getAll() throws StudentPortalException {
        List<Guardian> guardians = guardianServiceImpl.getAll();
        if(guardians.size()>=1){
            return new ResponseEntity<>(guardians,HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Guardian guardian) throws StudentPortalException {
       Guardian resultGuardian =guardianServiceImpl.add(guardian);
       if(resultGuardian.getName().equals(guardian.getName())){
           return new ResponseEntity<>(HttpStatus.CREATED);
       }else
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id) throws StudentPortalException {
        if (guardianServiceImpl.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
