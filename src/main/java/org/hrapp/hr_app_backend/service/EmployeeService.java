package org.hrapp.hr_app_backend.service;

import org.hrapp.hr_app_backend.dto.EmployeeDto;
import org.hrapp.hr_app_backend.dto.view.EmployeeViewDto;
import org.hrapp.hr_app_backend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(String empId);
    List<EmployeeViewDto> getAllEmployees();
    EmployeeDto updateEmployee(String empId, EmployeeDto updatedEmployee);
    void deleteEmployee(String empId);

}
