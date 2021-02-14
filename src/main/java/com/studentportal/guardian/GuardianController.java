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
    public ResponseEntity<GuardianDto> getById(@PathVariable("parentId") Long id) throws StudentPortalException {
        GuardianDto guardian = guardianServiceImpl.getById(id);
        if(guardian.getId().equals(id)){
            return  new ResponseEntity<>(guardian, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<GuardianDto>> getAll() throws StudentPortalException {
        List<GuardianDto> guardians = guardianServiceImpl.getAll();
        if(guardians.size()>=1){
            return new ResponseEntity<>(guardians,HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody GuardianDto guardianDto) throws StudentPortalException {
       GuardianDto resultGuardian = guardianServiceImpl.add(guardianDto);
       if(resultGuardian.getName().equals(guardianDto.getName())){
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
