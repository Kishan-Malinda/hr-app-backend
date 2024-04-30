package org.hrapp.hr_app_backend.mapper;

import org.hrapp.hr_app_backend.dto.EmployeeDto;
import org.hrapp.hr_app_backend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
          employee.getEmpId(),
          employee.getFirstName(),
          employee.getLastName(),
                employee.getNic(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getDob(),
                employee.getJobPositionId(),
                employee.getSalary(),
                employee.getDeptId()
        );
    }

    public static Employee maptoEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getEmpId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getNic(),
                employeeDto.getEmail(),
                employeeDto.getAddress(),
                employeeDto.getDob(),
                employeeDto.getJobPositionId(),
                employeeDto.getSalary(),
                employeeDto.getDeptId()
        );
    }
}
