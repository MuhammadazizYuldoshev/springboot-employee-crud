package uz.pdp.springbootemployeecrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootemployeecrud.model.Employee;
import uz.pdp.springbootemployeecrud.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public void save(Employee employee){
        repository.save(employee);

    }

    public Employee getEmployee(Integer id){
        return repository.findById(id).get();
    }


    public void delete(Integer id){
        repository.deleteById(id);
    }
}
