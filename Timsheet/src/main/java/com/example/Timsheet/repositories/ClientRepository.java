package com.example.Timsheet.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Timsheet.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
    
}