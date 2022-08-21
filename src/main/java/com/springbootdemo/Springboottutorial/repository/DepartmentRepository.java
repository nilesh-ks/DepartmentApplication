package com.springbootdemo.Springboottutorial.repository;


import com.springbootdemo.Springboottutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    //Since there's no method to fetch name in the JPA repository, we'll create a method to fetch the departments by their names
    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
