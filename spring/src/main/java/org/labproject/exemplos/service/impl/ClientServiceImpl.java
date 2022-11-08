package org.labproject.exemplos.service.impl;

import org.labproject.exemplos.model.Endereco;
import org.labproject.exemplos.model.AddressRepository;
import org.labproject.exemplos.model.Clientes;
import org.labproject.exemplos.model.ClientRepository;
import org.labproject.exemplos.service.ClientService;
import org.labproject.exemplos.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Clientes> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Clientes findById(Long id) {
        Optional<Clientes> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Clientes clientes) {
        saveClientWithCep(clientes);

    }

    @Override
    public void update(Long id, Clientes clientes) {
        Optional<Clientes> clientBd = clientRepository.findById(id);
        if (clientBd.isPresent()){
            saveClientWithCep(clientes);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithCep(Clientes clientes) {
        String cep = clientes.getAddress().getCep();
        Endereco endereco = addressRepository.findById(cep).orElseGet(() -> {
            Endereco newEndereco = viaCepService.consultCep(cep);
            addressRepository.save(newEndereco);
            return newEndereco;
        });
        clientes.setAddress(endereco);
        clientRepository.save(clientes);
    }
}
