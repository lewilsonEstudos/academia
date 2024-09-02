package br.edu.estudos.appAcademia.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.estudos.appAcademia.model.domain.Alimentacao;
import br.edu.estudos.appAcademia.model.repository.AlimentacaoRepository;

@Service
public class AlimentacaoService {

	@Autowired
	private AlimentacaoRepository alimentacaoRepository;

	public void incluir(Alimentacao alimentacao) {
		try {
			alimentacaoRepository.save(alimentacao);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public Iterable<Alimentacao> obterLista(){
		return alimentacaoRepository.findAll();
	}
	
	public Alimentacao obterPorId(Integer id) {
		return alimentacaoRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		alimentacaoRepository.deleteById(id);
	}	
}