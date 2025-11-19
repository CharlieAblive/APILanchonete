package com.example.lanchoneteAPI.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lanchoneteAPI.model.ClienteModel;
import com.example.lanchoneteAPI.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> listarTodos(){
        return clienteRepository.findAll();
    }

    public ClienteModel buscarPorId(int id){
        Optional<ClienteModel> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }
    public List<ClienteModel> buscarPorEmail(String email){
        List<ClienteModel> clientesPorEmail = null;
        List<ClienteModel> listaClientes = clienteRepository.findAll();
        for (ClienteModel c : listaClientes){
            if (c.getEmail() == email){
                clientesPorEmail.add(c);
            }
        } return clientesPorEmail;
    }


    public ClienteModel adicionarCliente (ClienteModel cliente){
        cliente.setAtivo(true);
        return clienteRepository.save(cliente);
    }

    public ClienteModel atualizarCliente (int id, ClienteModel clienteAtualizado){
        Optional<ClienteModel> clienteExiste = clienteRepository.findById(id);
        if (clienteExiste.isPresent()){
            ClienteModel cliente = clienteExiste.get();
            cliente.setNomeCompleto(clienteAtualizado.getNomeCompleto());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setPreferencias(clienteAtualizado.getPreferencias());
            //cliente.setEndereco(clienteAtualizado.getEndereco());
                return clienteRepository.save(cliente);
        } 

        return null;
    }
}