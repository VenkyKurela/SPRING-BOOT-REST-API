package com.spring.api.repository;

import com.spring.api.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long> {

  // public Department findBydepartmentName(String departmentName);
    public Department findBydepartmentNameIgnoreCase(String departmentName);

}
