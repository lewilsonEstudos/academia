package br.edu.estudos.appAcademia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.estudos.appAcademia.model.domain.Financeiro;
import br.edu.estudos.appAcademia.model.service.FinanceiroService;

@RestController
public class FinanceiroController {

	@Autowired
	private FinanceiroService financeiroService;
	
	@GetMapping(value = "financeiro/listar")
	public Iterable<Financeiro> obterLista(){
		return financeiroService.obterLista();
	}
	
	@GetMapping(value = "financeiro/{id}")
	public Financeiro obterPorId(@PathVariable Integer id) {
		return financeiroService.obterPorId(id);
	}
	
	@PostMapping(value = "financeiro/incluir")	
	public String incluir(@RequestBody(required = true) Financeiro financeiro) {
		
		financeiroService.incluir(financeiro);
		
		return "A inclusão do " + financeiro.getId()+ " foi realizada com sucesso!!!";
	}
	
	@DeleteMapping(value = "financeiro/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		financeiroService.excluir(id);
		
		return "A exclusão do id " + id + " foi realizada com sucesso!!!";
	}
}