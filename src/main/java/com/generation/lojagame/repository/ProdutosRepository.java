package com.generation.lojagame.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.lojagame.model.Produtos;



@Repository
public interface ProdutosRepository extends JpaRepository< Produtos, Long>{
	
	public List <Produtos> findAllBynomeContainingIgnoreCase(@Param("nome") String nome);
	
public List<Produtos> findByPrecoLessThan(BigDecimal preco);
	
	public List<Produtos> findByPrecoGreaterThan(BigDecimal preco);

}
