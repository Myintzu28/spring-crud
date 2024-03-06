package com.spring.POS.services.impl;

import com.spring.POS.dto.EmployeeDto;
import com.spring.POS.exception.ResourceNotFoundException;
import com.spring.POS.mapper.EmployeeMapper;
import com.spring.POS.models.Employee;
import com.spring.POS.repo.EmployeeRepository;
import com.spring.POS.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getEmail() == null || employeeDto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required.");
        }

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with given id :" + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}