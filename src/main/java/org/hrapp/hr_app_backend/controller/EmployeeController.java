package org.hrapp.hr_app_backend.controller;

import lombok.AllArgsConstructor;
import org.hrapp.hr_app_backend.dto.EmployeeDto;
import org.hrapp.hr_app_backend.dto.view.EmployeeViewDto;
import org.hrapp.hr_app_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //CREATE Employee Rest API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // GET Single Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") String empId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(empId);
        return ResponseEntity.ok(employeeDto);
    }

    //GET All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeViewDto>> getAllEmployees(){
        List<EmployeeViewDto> employeeViewDtoList =  employeeService.getAllEmployees();
        System.out.println(employeeViewDtoList.toString());
        return  ResponseEntity.ok(employeeViewDtoList);
    }

    //UPDATE Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") String empId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(empId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    // DELETE Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String empId){
        employeeService.deleteEmployee(empId);
        return ResponseEntity.ok("Employee Deleted Successfully...");
    }
}
