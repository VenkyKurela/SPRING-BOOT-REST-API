package com.spring.api.service;

import com.spring.api.entity.Department;
import java.util.List;
import java.util.Map;

public interface DepartmentService {


    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);


    public void deleteDepartmentById(Long departmentId);

    public Department updateDaprtment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);

    Department partialUpdateDepartment(Long departmentId, Map<String, Object> updates);

    boolean checkIfDepartmentExists(Long departmentId);

    //public Department deleteDepartmentByName(String departmentName);
}
