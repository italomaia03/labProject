package org.labproject.exemplos.service;

import org.labproject.exemplos.model.Clientes;

public interface ClientService {

    Iterable<Clientes> findAll();
    Clientes findById(Long id);
    void insert(Clientes clientes);
    void update(Long id, Clientes clientes);
    void delete(Long id);


}
