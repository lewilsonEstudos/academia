package br.edu.estudos.appAcademia.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.estudos.appAcademia.model.domain.Aparelho;
import br.edu.estudos.appAcademia.model.repository.AparelhoRepository;

@Service
public class AparelhoService {

	@Autowired
	private AparelhoRepository aparelhoRepository;
	
	public void incluir(Aparelho aparelho) {
		try {
			aparelhoRepository.save(aparelho);
		} catch (Exception e) {
			System.err.println("Erro ao incluir " + e.getMessage());
		}
	}
	
	public Iterable<Aparelho> obterLista(){
		return aparelhoRepository.findAll();
	}
	
	public Aparelho obterPorId(Integer id) {
		return aparelhoRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		aparelhoRepository.deleteById(id);
	}		
}