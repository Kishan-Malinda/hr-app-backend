package org.hrapp.hr_app_backend.mapper.view;

import org.hrapp.hr_app_backend.dto.EmployeeDto;
import org.hrapp.hr_app_backend.dto.view.EmployeeViewDto;
import org.hrapp.hr_app_backend.entity.Employee;

public class EmployeeViewMapper {
    public static EmployeeViewDto mapToEmployeeViewDto(Employee employee){
        return new EmployeeViewDto(
                employee.getEmpId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getNic(),
                employee.getEmail()
        );
    }


}
