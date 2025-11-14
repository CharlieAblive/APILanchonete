package com.example.lanchoneteAPI.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lanchoneteAPI.model.*;
import com.example.lanchoneteAPI.repository.LanchoneteRepository;

@Service
public class LanchoneteService {

    @Autowired
    private LanchoneteRepository lanchoneteRepository;

    public List<ProdutoModel> listarTodos(){
        return lanchoneteRepository.findAll();
    }

    public ProdutoModel buscarPorId(int id){
        Optional<ProdutoModel> produto = lanchoneteRepository.findById(id);
        return produto.orElse(null);
    }
    public List<ProdutoModel> buscarPorCategoria(String categoria){
        List<ProdutoModel> produtosPorCategoria = null;
        List<ProdutoModel> listaProdutos = lanchoneteRepository.findAll();
        for (ProdutoModel p : listaProdutos){
            if (p.getCategoria() == categoria){
                produtosPorCategoria.add(p);
            }
        } return produtosPorCategoria;
    }

    public ProdutoModel adicionarProduto(ProdutoModel produto){
        return lanchoneteRepository.save(produto);
    }

    public void deletarProduto(int id){
        lanchoneteRepository.deleteById(id); 
    }

    public ProdutoModel dispobibilidadeProduto(ProdutoModel produto){
        if (produto.isDisponivel()){
            return produto;
        } else return null;
    }

    public ProdutoModel atualizarProduto(int id, ProdutoModel produtoAtualizado){
        Optional<ProdutoModel> produtoExiste = lanchoneteRepository.findById(id);
        if (produtoExiste.isPresent()){
            ProdutoModel produto = produtoExiste.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setCategoria(produtoAtualizado.getCategoria());
            produto.setTempoPreparo(produtoAtualizado.getTempoPreparo());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setDisponivel(true);
                return lanchoneteRepository.save(produto);
        } 

        return null;
    }
}