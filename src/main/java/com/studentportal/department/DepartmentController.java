package com.studentportal.department;

import java.util.List;

import com.studentportal.exception.StudentPortalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentServiceImpl departmentService;
    public DepartmentController(DepartmentServiceImpl departmentService){
        this.departmentService = departmentService;
    }


    @GetMapping("{departmentId}")
    public ResponseEntity<Department> getById(@PathVariable ("departmentId") Long id) throws StudentPortalException {
        Department department= departmentService.getById(id);
        if(department.getId().equals(id)){
            return  new ResponseEntity<>(department,HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @GetMapping("name/{departmentName}")
    public ResponseEntity<Department> getByName(@PathVariable ("departmentName") String departmentName) throws StudentPortalException, StudentPortalException {
        Department department= departmentService.getByName(departmentName);
        if (department.getDepartmentName().equals(departmentName)){
            return new ResponseEntity<>(department,HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<Department>> getAll() throws StudentPortalException {
        List<Department> departmentList= departmentService.getAll();
        if(departmentList.size()<1){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity<>(departmentList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Department> save(@RequestBody Department department) throws StudentPortalException {
        Department result= departmentService.save(department);
        if(result.getDepartmentName().equals(department.getDepartmentName())){
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id) throws StudentPortalException {
        if(departmentService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
