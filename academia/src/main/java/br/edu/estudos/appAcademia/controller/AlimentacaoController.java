package br.edu.estudos.appAcademia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.estudos.appAcademia.model.domain.Alimentacao;
import br.edu.estudos.appAcademia.model.service.AlimentacaoService;

@RestController
public class AlimentacaoController {

	@Autowired
	private AlimentacaoService alimentacaoService;
	
	@GetMapping(value = "alimentacao/listar")
	public Iterable<Alimentacao> obterLista(){
		return alimentacaoService.obterLista();
	}
	
	@GetMapping(value = "alimentacao/{id}")
	public Alimentacao obterPorId(@PathVariable Integer id) {
		return alimentacaoService.obterPorId(id);
	}
	
	@PostMapping(value = "alimentacao/incluir")	
	public String incluir(@RequestBody(required = true) Alimentacao alimentacao) {
		
		alimentacaoService.incluir(alimentacao);
		
		return "A inclusão do " + alimentacao + " foi realizada com sucesso!!!";
	}
	
	@DeleteMapping(value = "alimentacao/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		alimentacaoService.excluir(id);
		
		return "A exclusão do id " + id + " foi realizada com sucesso!!!";
	}
}