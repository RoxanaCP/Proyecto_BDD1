package com.ventaropa.venta.Service;

import com.ventaropa.venta.DTO.ClienteDTO;
import com.ventaropa.venta.DTO.ClienteVista;
import com.ventaropa.venta.Entity.Cliente;
import com.ventaropa.venta.Entity.Persona;
import com.ventaropa.venta.Repository.ClienteRepository;
import com.ventaropa.venta.Repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    @Autowired
    private PersonaRepository personaRepository;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public String buscar(Integer id) {
        Cliente cliTemp = repo.findById(id).orElse(null);
        if (cliTemp == null) return null; // por si no existe

        Persona perTemp = personaRepository.findById(cliTemp.getIdPersona()).orElse(null);
        if (perTemp == null) return null;

        return perTemp.getNombre();
    }

    public Optional<ClienteVista> vista(Integer id) {
        return repo.vistaById(id);
    }

    public Cliente agregarCliente(ClienteDTO dto) {
            Persona persona = new Persona();
            persona.setIdPais(dto.getIdPais());
            persona.setNombre(dto.getNombre());
            persona.setGenero(dto.getGenero());
            persona.setFechaNacimiento(dto.getFechaNacimiento());
            persona.setTelefono(dto.getTelefono());
            persona = personaRepository.save(persona); // guarda y obtiene el ID

            Cliente cliente = new Cliente();
            cliente.setIdPersona(persona.getIdPersona()); // <-- aquí va el ID correcto
            cliente.setNit(dto.getNit());
            cliente.setEmail(dto.getEmail());
            cliente.setFechaCreacion(new Date());

            return repo.save(cliente);

    }

     public void eliminarClienteYPersona(Integer idCliente) {
        // 1. Buscar cliente
        Cliente cliente = repo.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // 2. Borrar cliente primero
        Integer idPersona = cliente.getIdPersona();
        repo.delete(cliente);

        // 3. Borrar persona asociada
       
        if(idPersona != null){
            personaRepository.deleteById(idPersona);
        }
    }


}
