package com.empresa.erp.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.erp.crm.model.Cliente;
import com.empresa.erp.crm.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    // Obtener cliente por ID
    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    // Crear o actualizar cliente
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar cliente por ID
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }



   
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
    
    Cliente clienteExistente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));

  
    clienteExistente.setNombre(clienteActualizado.getNombre());
    clienteExistente.setEmail(clienteActualizado.getEmail());
    clienteExistente.setTelefono(clienteActualizado.getTelefono());


    return clienteRepository.save(clienteExistente);
}

}
