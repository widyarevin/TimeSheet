package com.example.Timsheet.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Timsheet.models.Client;
import com.example.Timsheet.services.ClientService;


@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientRestController {
       private ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAll(){
        return clientService.getAll();
    }

}
