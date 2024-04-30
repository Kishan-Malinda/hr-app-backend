package org.hrapp.hr_app_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String empId;
    private String firstName;
    private String lastName;
    private String nic;
    private String email;
    private String address;
    private Date dob;
    private int jobPositionId;
    private double salary;
    private String deptId;
}
