
package com.example.Timsheet.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Timsheet.models.Role;
import com.example.Timsheet.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Integer id) {
        return roleRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Role tidak ditemukan"));
    }

    @Override
    public boolean save(Role role) {
        roleRepository.save(role);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        roleRepository.deleteById(id);
        return !roleRepository.findById(id).isPresent();
    }

    @Override
    public int getIdByLevel() {
        return roleRepository.findMaxLevel();
    }
    
}
