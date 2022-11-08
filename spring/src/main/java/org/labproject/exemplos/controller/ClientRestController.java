package org.labproject.exemplos.controller;

import org.labproject.exemplos.model.Clientes;
import org.labproject.exemplos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Clientes>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Clientes> insert(@RequestBody Clientes clientes){
        clientService.insert(clientes);
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> update(@PathVariable Long id, @RequestBody Clientes clientes){
        clientService.update(id, clientes);
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Clientes> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

}
