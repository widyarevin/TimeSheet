package com.example.Timsheet.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Timsheet.models.Client;
import com.example.Timsheet.repositories.ClientRepository;
@Service
public class ClientServiceImpl implements ClientService{
    
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Integer id) {
        return clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client tidak ditemukan"));
    }

    @Override
    public boolean save(Client client) {
        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        clientRepository.deleteById(id);
        return !clientRepository.findById(id).isPresent();
    }
    
    
}
