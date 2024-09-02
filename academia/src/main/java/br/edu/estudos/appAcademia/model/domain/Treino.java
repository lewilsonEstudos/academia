package br.edu.estudos.appAcademia.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TTreino")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Treino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "É necessário o preenchimento do campo mudarTreino.")
	private String mudarTreino;
	
	
	@Column(unique = true)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	@JsonBackReference
	private Usuario usuario;

	@Override
	public String toString() {
		return String.format("%d;%s;%d;%.2f;%s;%s",
				id,
				mudarTreino, 
				codigo,
				usuario
			);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMudarTreino() {
		return mudarTreino;
	}

	public void setMudarTreino(String mudarTreino) {
		this.mudarTreino = mudarTreino;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}