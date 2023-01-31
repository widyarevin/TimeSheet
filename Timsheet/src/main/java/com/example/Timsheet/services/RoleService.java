package com.example.Timsheet.services;

import java.util.List;
import com.example.Timsheet.models.Role;

public interface RoleService {
    public List<Role> getAll();
    public Role getById(Integer id);
    public boolean save(Role role);
    public boolean delete(Integer id);
    public int getIdByLevel();
}
