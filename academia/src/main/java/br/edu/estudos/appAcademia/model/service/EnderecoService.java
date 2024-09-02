package br.edu.estudos.appAcademia.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.estudos.appAcademia.client.EnderecoClient;
import br.edu.estudos.appAcademia.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoClient enderecoClient;

	public Endereco obterPorCep(String cep) {
		return enderecoClient.findByCep(cep);
	}
}