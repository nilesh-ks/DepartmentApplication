package com.springbootdemo.Springboottutorial.service;

import com.springbootdemo.Springboottutorial.entity.Department;
import com.springbootdemo.Springboottutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("ISE")
                .departmentAddress("Hyderabad")
                .departmentCode("ISE-03")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("ISE")).thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on valid Department name")
    public void whenValidDepartmentName_thenDepartmentCalled() {
        String departmentName = "ISE";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}