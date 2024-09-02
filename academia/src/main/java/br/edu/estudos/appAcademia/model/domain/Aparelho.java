package br.edu.estudos.appAcademia.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TAparelho")
public class Aparelho extends Treino {
	
	private String nomeAparelho;
	private String marca;

	
	@Override
	public String toString() {
		return String.format("%s;%s;%s",super.toString(), marca, nomeAparelho);
	}
		
	public String getNomeAparelho() {
		return nomeAparelho;
	}

	public void setNomeAparelho(String nomeAparelho) {
		this.nomeAparelho = nomeAparelho;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}