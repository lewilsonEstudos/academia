package br.edu.estudos.appAcademia.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.estudos.appAcademia.model.domain.Financeiro;
import br.edu.estudos.appAcademia.model.repository.FinanceiroRepository;

@Service
public class FinanceiroService {

	@Autowired
	private FinanceiroRepository financeiroRepository;

	public void incluir(Financeiro financeiro) {
		try {
			financeiroRepository.save(financeiro);
		} catch (Exception e) {
			System.err.println("Erro ao adicionar financeiro " + e.getMessage());
		}
	}
	
	public Iterable<Financeiro> obterLista(){
		return financeiroRepository.findAll();
	}
	
	public Financeiro obterPorId(Integer id) {
		return financeiroRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		financeiroRepository.deleteById(id);
	}	
}