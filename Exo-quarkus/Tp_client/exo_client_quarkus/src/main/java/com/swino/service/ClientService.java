package com.swino.service;

import com.swino.entity.Client;
import com.swino.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    public List<Client> findAllClients() {
        return clientRepository.listAll();
    }

    public Client findClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Client createClient(Client client) {
        clientRepository.persist(client);
        return client;
    }

    @Transactional
    public Client updateClient(Long id, Client clientData) {
        Client client = clientRepository.findById(id);
        if (client != null) {
            client.setCliName(clientData.getCliName());
            client.setCliEmail(clientData.getCliEmail());
            client.setCliPhone(clientData.getCliPhone());
        }
        return client;
    }

    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
