package br.com.service;

import br.com.domain.Client;
import br.com.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    public List<Client> getAllClient(){
        return clientRepository.listAll();
    }

    public Client postClient(Client client){
        clientRepository.persist(client);
        return client;
    }

}
