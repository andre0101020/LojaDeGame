package com.generation.lojagame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "tb_produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do jogo é Obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 1, max = 100, message = "O nome do jogo deve conter no mínimo 1 e no máximo 100 caractéres")
	private String nome; //nome do jogo 
	
	@NotBlank(message = "O descrição do jogo é Obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 1, max = 300, message = "O descrição do jogo deve conter no mínimo 05 e no máximo 300 caractéres")
	private String descricao; //um pouco sobre o jogo
	
	@NotBlank(message = "O link direto da foto do produto é obrigatório")
	private String foto;  //Foto do seu produto 
	
	@PositiveOrZero(message = "insira um preço valido")
	private double preco; //preço do jogo
	
	@NotBlank(message = "O console que roda o jogo é obrigatório")
	private String console;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
