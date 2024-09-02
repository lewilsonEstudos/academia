package br.edu.estudos.appAcademia.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TUsuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String sobrenome;

	private Integer idade;

	@Column(name = "dsemail")
	private String email;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	@JsonManagedReference	
	private List<Treino> treino;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	@JsonManagedReference
	private Endereco endereco;

	// Relacionamento OneToMany com Financeiro
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Financeiro> financeiros;

	
	// Relacionamento OneToMany com Financeiro
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Alimentacao> alimentacao;
	
	public Usuario() {
		treino = new ArrayList<Treino>();
	}

	@Override
	public String toString() {
		return id + ";" + nome + ";" + sobrenome + ";" + idade + ";" + email + ";" + treino.size() +";"+ financeiros + alimentacao +"; cep: "
				+ endereco.getCep();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Treino> getTreino() {
		return treino;
	}

	public void setTreino(List<Treino> treino) {
		this.treino = treino;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Financeiro> getFinanceiros() {
		return financeiros;

	}

	
	public List<Alimentacao> getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(List<Alimentacao> alimentacao) {
		this.alimentacao = alimentacao;
	}

	public void setFinanceiros(List<Financeiro> financeiros) {
		this.financeiros = financeiros;
	}
}