package com.example.Timsheet.services;

import java.util.List;

import com.example.Timsheet.models.Division;

public interface DivisionService {
    public List<Division> getAll();
    public Division getById(Integer id);
    public boolean save(Division division);
    public boolean delete(Integer id);
}
