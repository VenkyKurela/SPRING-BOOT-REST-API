package com.spring.api.controller;
import com.spring.api.entity.*;
import com.spring.api.entity.Department;
import com.spring.api.service.DepartmentService;
import com.spring.api.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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





}
