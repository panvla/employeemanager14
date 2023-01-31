package com.vladimirpandurov.employeemanagerF.controller;


import com.vladimirpandurov.employeemanagerF.model.Employee;
import com.vladimirpandurov.employeemanagerF.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

        private final EmployeeService employeeService;

        @GetMapping("/{id}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
            Employee employee = this.employeeService.findEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        @GetMapping
        public ResponseEntity<List<Employee>> getAllEmployees(){
            List<Employee> employees = this.employeeService.findAllEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        @PostMapping
        public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
            Employee newEmployee = this.employeeService.addEmployee(employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        }
        @PutMapping
        public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
            Employee updatedEmployee = this.employeeService.updateEmployee(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
            this.employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

}
