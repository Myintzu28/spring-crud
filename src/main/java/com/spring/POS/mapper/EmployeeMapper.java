package com.spring.POS.mapper;

import com.spring.POS.dto.EmployeeDto;
import com.spring.POS.models.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
       return new EmployeeDto(
           employee.getId(),
           employee.getFirstName(),
           employee.getLastName(),
           employee.getEmail()
       );
    }

}
