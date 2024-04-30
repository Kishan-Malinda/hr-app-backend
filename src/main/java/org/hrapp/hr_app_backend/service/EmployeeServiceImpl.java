package org.hrapp.hr_app_backend.service;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hrapp.hr_app_backend.dto.EmployeeDto;
import org.hrapp.hr_app_backend.dto.view.EmployeeViewDto;
import org.hrapp.hr_app_backend.entity.Employee;
import org.hrapp.hr_app_backend.exception.DuplicateResourceException;
import org.hrapp.hr_app_backend.exception.RosourceNotFoundException;
import org.hrapp.hr_app_backend.mapper.EmployeeMapper;
import org.hrapp.hr_app_backend.mapper.view.EmployeeViewMapper;
import org.hrapp.hr_app_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        boolean foundEmployee = employeeRepository.findById(employeeDto.getEmpId()).isEmpty();

        if(!foundEmployee)
            throw new DuplicateResourceException("Employee Found with given Id : "+employeeDto.getEmpId()+".");

        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(String empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(()->
                new RosourceNotFoundException("Employee does NOT exist with given Id : "+empId+".") );

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

//    @Override
//    public List<EmployeeDto> getAllEmployees() {
//        List<Employee> employees = employeeRepository.findAll();
//        return employees.stream().map( (employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
//    }
    @Override
    public List<EmployeeViewDto> getAllEmployees() {
        List<Employee> employeeViewList = employeeRepository.findAll();
        return employeeViewList.stream().map( (employee) -> EmployeeViewMapper.mapToEmployeeViewDto(employee)).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(String empId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                ()-> new RosourceNotFoundException("Employee does NOT exist with given Id : "+empId+"."));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setNic(updatedEmployee.getNic());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setAddress(updatedEmployee.getAddress());
        employee.setDob(updatedEmployee.getDob());
        employee.setJobPositionId(updatedEmployee.getJobPositionId());
        employee.setSalary(updatedEmployee.getSalary());
        employee.setDeptId(updatedEmployee.getDeptId());

        Employee updatedEmployeeRecord = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeRecord);
    }

    @Override
    public void deleteEmployee(String empId) {

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                ()-> new RosourceNotFoundException("Employee does NOT exist with given Id : "+empId+"."));

        employeeRepository.deleteById(empId);
    }
}
