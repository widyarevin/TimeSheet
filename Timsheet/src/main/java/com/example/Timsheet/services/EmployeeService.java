package com.example.Timsheet.services;

import java.util.List;
import com.example.Timsheet.models.Employee;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getById(Integer id);
    public boolean save(Employee employee);
    public boolean delete(Integer id);
}
