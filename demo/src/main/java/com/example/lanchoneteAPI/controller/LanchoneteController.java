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

import com.example.lanchoneteAPI.model.ProdutoModel;
import com.example.lanchoneteAPI.service.LanchoneteService;


@RestController
@RequestMapping("api/produtos")
public class LanchoneteController {

    @Autowired
    private LanchoneteService lanchoneteService;
@GetMapping
public ResponseEntity<List<ProdutoModel>> listarTodos(ProdutoModel produto){
    if (produto.isDisponivel()){
    List<ProdutoModel> produtos = lanchoneteService.listarTodos();
    return ResponseEntity.ok(produtos);
    }
    return null;
}

@GetMapping("/{id}")
public ResponseEntity<ProdutoModel> buscarPorId(@PathVariable int id){
    ProdutoModel produto = lanchoneteService.buscarPorId(id); 
        if(produto != null){
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
}

@GetMapping("/indisponiveis")
public ResponseEntity<List<ProdutoModel>> listarIndisponiveis(ProdutoModel produto){
    if (!produto.isDisponivel()){
    List<ProdutoModel> produtos = lanchoneteService.listarTodos();
    return ResponseEntity.ok(produtos);
    }
    return null;
}

@PostMapping 
public ResponseEntity<ProdutoModel> adicionarProduto(@RequestBody ProdutoModel produto ){
    ProdutoModel produtoSalvo = lanchoneteService.adicionarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
}


@PutMapping("/{id}")
public ResponseEntity<ProdutoModel> atualizarProduto(@PathVariable int id,  @RequestBody ProdutoModel produto){
    ProdutoModel produtoAtualizado = lanchoneteService.atualizarProduto(id, produto);
        if(produtoAtualizado != null){
            return ResponseEntity.ok(produtoAtualizado);
        }
        return ResponseEntity.notFound().build();
}
}
