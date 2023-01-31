package com.example.Timsheet.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Timsheet.DTO.LoginDTO;
import com.example.Timsheet.DTO.RegisterDTO;
import com.example.Timsheet.models.Designation;
import com.example.Timsheet.models.Employee;
import com.example.Timsheet.models.Role;
import com.example.Timsheet.models.User;
import com.example.Timsheet.repositories.EmployeeRepository;
import com.example.Timsheet.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserRepository userRepository;
    @Autowired 
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("User tidak ditemukan"));
    }


    @Override
    public boolean save(RegisterDTO registerDTO) {
        User user = new User();
        Employee employee = new Employee();
        Role role = new Role();
        Designation designation = new Designation();

        System.out.println(registerDTO.getName() + "dshvhjds");
        System.out.println(registerDTO.getEmail() + "wmaill");
        user.setRole(role);
        role.setId(roleService.getIdByLevel());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        userRepository.save(user);

        employee.setId(user.getId());
        employee.setNik(registerDTO.getNik());
        employee.setName(registerDTO.getName());
        employee.setBirthdate(registerDTO.getBirthdate());
        employee.setEmail(registerDTO.getEmail());
        designation.setId(registerDTO.getDesignation());
        employee.setDesignation(designation);
        employeeRepository.save(employee);
        

        return userRepository.findById(user.getId()).isPresent();
    }

    @Override
    public boolean delete(Integer id) {
        userRepository.deleteById(id);
        return !userRepository.findById(id).isPresent();
    }

     @Override
    public boolean LoginEmp(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user.getEmployee().getEmail() != null && passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())){
            return true;
        } return false;
    }   


    @Override
    public Integer getIdByEmail(String email) {
        return userRepository.findIdByEmail(email);
    }

   
    
}
