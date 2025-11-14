package com.example.lanchoneteAPI.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lanchoneteAPI.model.ProdutoModel;

@Repository
public interface LanchoneteRepository extends JpaRepository<ProdutoModel, Integer> {

}
