package com.spring.api.service;

import com.spring.api.entity.Department;
import com.spring.api.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDaprtment(Long departmentId, Department department) {
        Department dept = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            dept.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            dept.setDepartmentAddress(department.getDepartmentAddress());
        }


        return departmentRepository.save(dept);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findBydepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public Department partialUpdateDepartment(Long departmentId, Map<String, Object> updates) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department Not Found"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "departmentName":
                    department.setDepartmentName((String) value);
                    break;
                case "departmentAddress":
                    department.setDepartmentAddress((String) value);
                case "departmentCode":
                    department.setDepartmentCode((String) value);
            }
        });

        return departmentRepository.save(department);
    }

    @Override
    public boolean checkIfDepartmentExists(Long departmentId) {
        return departmentRepository.existsById(departmentId);
    }
}




