package com.example.lanchoneteAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lanchoneteAPI.model.ClienteModel;
import com.example.lanchoneteAPI.model.ProdutoModel;
import com.example.lanchoneteAPI.service.ClienteService;


@RestController
@RequestMapping("api/clientes")
public class ClienteController
 {

    @Autowired
    private ClienteService clienteService;
@GetMapping
public ResponseEntity<List<ClienteModel>> listarTodos(ClienteModel cliente){
    //if (Cliente.isDisponivel()){
    List<ClienteModel> Clientes = clienteService.listarTodos();
    return ResponseEntity.ok(Clientes);
   }
  // return null;
//}

@GetMapping("/{id}")
public ResponseEntity<ClienteModel> buscarPorId(@PathVariable int id){
    ClienteModel cliente = clienteService.buscarPorId(id); 
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
}


@GetMapping("/indisponiveis")
public ResponseEntity<List<ClienteModel>> listarIndisponiveis(ClienteModel cliente){
    if (!cliente.isAtivo()){
    List<ClienteModel> clientes = clienteService.listarTodos();
    return ResponseEntity.ok(clientes);
    }
    return null;
}

@PostMapping 
public ResponseEntity<ClienteModel> adicionarCliente(@RequestBody ClienteModel cliente ){
    ClienteModel clienteSalvo = clienteService.adicionarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
}


@PutMapping("/{id}")
public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable int id,  @RequestBody ClienteModel cliente){
    ClienteModel clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        if(clienteAtualizado != null){
            return ResponseEntity.ok(clienteAtualizado);
        }
        return ResponseEntity.notFound().build();
}
}
