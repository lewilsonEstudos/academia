package br.edu.estudos.appAcademia.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.estudos.appAcademia.model.domain.Treino;
import br.edu.estudos.appAcademia.model.repository.TreinoRepository;

@Service
public class TreinoService {

	@Autowired
	private TreinoRepository treinoRepository;

	public Iterable<Treino> obterLista(){
		return treinoRepository.findAll();
	}

	public long obterQtde() {
		return treinoRepository.count();
	}
	
	public Collection<Treino> obterListaPorUsuario(Integer id){
		return treinoRepository.findByUsuarioId(id);
	}

}