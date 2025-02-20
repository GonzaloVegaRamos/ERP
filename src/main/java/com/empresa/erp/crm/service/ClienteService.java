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

        // Busca el cliente existente en la base de datos por su ID.
        // Si no lo encuentra, lanza una excepción con un mensaje de error.
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    
        // Actualiza los valores del cliente existente con los valores del cliente actualizado que recibe como parámetro.
        // Cambia el nombre del cliente.
        clienteExistente.setNombre(clienteActualizado.getNombre());
    
        // Cambia el correo electrónico del cliente.
        clienteExistente.setEmail(clienteActualizado.getEmail());
    
        // Cambia el número de teléfono del cliente.
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
    
        // Guarda los cambios en el repositorio (base de datos) y devuelve el cliente actualizado.
        return clienteRepository.save(clienteExistente);
    }
    

}
