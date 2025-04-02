package com.spring.api.controller;
import com.spring.api.entity.*;
import com.spring.api.entity.Department;
import com.spring.api.service.DepartmentService;
import com.spring.api.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.slf4j.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department)
    {
        LOGGER.info("Inside the saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        LOGGER.info("Inside the fetchDepartmentList  of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepatmentById(@PathVariable("id") Long departmentId)
    {
        LOGGER.info("Inside the fetchDepartmentById  of DepartmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
    {
        LOGGER.info("Inside the deleteDepartmentById  of DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully..!!!";
    }


    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department)
    {
        LOGGER.info("Inside the updateDepartment  of DepartmentController");
        return departmentService.updateDaprtment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
    {
        LOGGER.info("Inside the fetchDepartmentByName  of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @PatchMapping("departments/patch/{id}")
    public Department partialUpdateDepartment(@PathVariable("id") Long departmentId, @RequestBody
    Map<String, Object> updates)
    {
        LOGGER.info("Inside the partialUpdateDepartment  of PatchController");
        Department updateDepartment = departmentService.partialUpdateDepartment(departmentId, updates);
        return ResponseEntity.ok(updateDepartment).getBody();

    }

    @RequestMapping(method = RequestMethod.HEAD, path = "/{id}")
    public ResponseEntity<Void> headDepartment(@PathVariable("id") Long departmentId)
    {   LOGGER.info("Inside the headDepartment  of HeadController");
        boolean exists = departmentService.checkIfDepartmentExists(departmentId);

        if(exists)
        {
            return ResponseEntity.ok()
                    .header("Message","Department exists")
                    .build(); // http 200
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Message", "Department not found")
                    .build();  //http 404
        }
    }





}
