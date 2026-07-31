package deborshi.employee_management.services;

import deborshi.employee_management.entities.EmployeeEntitiy;
import deborshi.employee_management.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class EmployeeService {

    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }






}
