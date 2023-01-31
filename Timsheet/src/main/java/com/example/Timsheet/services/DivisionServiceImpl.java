package com.example.Timsheet.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Timsheet.models.Division;
import com.example.Timsheet.repositories.DivisionRepository;


@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> getAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division getById(Integer id) {
        return divisionRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Division tidak ditemukan"));
    }

    @Override
    public boolean save(Division division) {
        divisionRepository.save(division);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        divisionRepository.deleteById(id);
        return !divisionRepository.findById(id).isPresent();
    }
    
}
