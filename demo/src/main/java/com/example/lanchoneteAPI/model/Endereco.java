package com.example.lanchoneteAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private String bairro; 
    @Column(nullable = false)
    private String cidade;

    public Endereco(){

    }
    public Endereco(String rua, int numero, String bairro, String cidade){
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }
}
