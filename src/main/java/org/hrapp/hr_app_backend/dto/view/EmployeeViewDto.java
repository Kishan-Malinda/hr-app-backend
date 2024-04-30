package org.hrapp.hr_app_backend.dto.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeViewDto {
    private String empId;
    private String firstName;
    private String lastName;
    private String nic;
    private String email;
}
