package com.example.Timsheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Timsheet.models.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer>{
    
}
