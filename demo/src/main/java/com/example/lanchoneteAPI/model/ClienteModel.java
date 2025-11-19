package com.example.lanchoneteAPI.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClienteModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private int id;

@Column(nullable = false)
private String nomeCompleto;

@Column(nullable = false, length = 100)
private String email;

@Column(nullable = false)
private String telefone;

//@Column(nullable = false)
//private Endereco endereco;

@Column(nullable = false)
private String data = LocalDate.now().toString();

@Column(nullable = false)
private boolean ativo = true;

@Column(nullable = true)
private String preferencias;

@Column(nullable = false)
private String histCompra;

@Column(nullable = false)
private Long cpf;

@Column(nullable = false)
private String pedidos;


public ClienteModel(){

}


public ClienteModel(int id, String nomeCompleto, String email, String telefone, String data,
        boolean ativo, String preferencias, String histCompra, Long cpf, String pedidos) {
    this.id = id;
    this.nomeCompleto = nomeCompleto;
    this.email = email;
    this.telefone = telefone;
    //this.endereco = endereco;
    this.data = data;
    this.ativo = ativo;
    this.preferencias = preferencias;
    this.histCompra = histCompra;
    this.cpf = cpf;
    this.pedidos = pedidos;
}
}