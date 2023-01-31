package com.example.Timsheet.services;

import java.util.List;
import com.example.Timsheet.models.Client;


public interface ClientService {
    public List<Client> getAll();
    public Client getById(Integer id);
    public boolean save(Client client);
    public boolean delete(Integer id);

}
