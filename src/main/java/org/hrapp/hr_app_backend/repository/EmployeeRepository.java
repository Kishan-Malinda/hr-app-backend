package org.hrapp.hr_app_backend.repository;

import org.hrapp.hr_app_backend.dto.view.EmployeeViewDto;
import org.hrapp.hr_app_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {


}
