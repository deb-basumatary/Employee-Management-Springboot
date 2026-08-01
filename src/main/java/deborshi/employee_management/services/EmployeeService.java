package deborshi.employee_management.services;

import deborshi.employee_management.dto.EmployeeDTO;
import deborshi.employee_management.entities.EmployeeEntitiy;
import deborshi.employee_management.exceptions.ResourceNotFoundException;
import deborshi.employee_management.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id){
        return employeeRepository.findById(id)
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeEntitiy> employeeList = employeeRepository.findAll();

        return employeeList.stream().map(a->modelMapper.map(a, EmployeeDTO.class)).collect(Collectors.toList());

    }

    public EmployeeDTO createEmployee(EmployeeDTO employee){
        EmployeeEntitiy employeeEntitiy = modelMapper.map(employee, EmployeeEntitiy.class);
        employeeEntitiy = employeeRepository.save(employeeEntitiy);
        return modelMapper.map(employeeEntitiy, EmployeeDTO.class);
    }

    public void isEmployeeExist(Long id){
        boolean exist = employeeRepository.existsById(id);
        if(!exist) throw new ResourceNotFoundException("Employee not found for id: " + id);
    }

    public boolean deleteEmployee(Long id){
        isEmployeeExist(id);
        employeeRepository.deleteById(id);
        return true;
    }


}
