package br.edu.estudos.appAcademia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.estudos.appAcademia.model.domain.Aparelho;
import br.edu.estudos.appAcademia.model.service.AparelhoService;

@RestController
public class AparelhoController {

	@Autowired
	private AparelhoService aparelhoService;
		
	@GetMapping(value = "aparelho/listar")
	public Iterable<Aparelho> obterLista(){
		return aparelhoService.obterLista();
	}
	
	@GetMapping(value = "aparelho/{id}")
	public Aparelho obterPorId(@PathVariable Integer id) {
		return aparelhoService.obterPorId(id);
	}
	
	@PostMapping(value = "aparelho/incluir")	
	public String incluir(@RequestBody(required = true) Aparelho aparelho) {
		
		aparelhoService.incluir(aparelho);
		
		return "A inclusão do " + aparelho + " foi realizada com sucesso!!!";
	}
	
	@DeleteMapping(value = "aparelho/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		aparelhoService.excluir(id);
		
		return "A exclusão do id " + id + " foi realizada com sucesso!!!";
	}
}