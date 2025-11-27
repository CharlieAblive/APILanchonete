package com.example.lanchoneteAPI.model;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "produtos")
@Getter
@Setter
@CrossOrigin(origins = "*")
public class ProdutoModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private int id;

@Column(nullable = false)
private String categoria;

@Column(nullable = false, length = 100)
private String nome;

@Column(nullable = false)
private String descricao;

@Column(nullable = false)
private boolean disponivel;

@Column(nullable = false)
private Double preco;

@Column(nullable = false)
private String tempoPreparo;

public ProdutoModel(){

}
public ProdutoModel(int id, String categoria, String nome, String descricao, boolean disponivel, Double preco, String tempoPreparo){

    this.id = id;
    this.nome = nome;
    this.preco = preco;
    this.categoria = categoria;
    this.descricao = descricao;
    this.disponivel = disponivel;
    this.tempoPreparo = tempoPreparo;
}



}

