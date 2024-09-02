package br.edu.estudos.appAcademia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.estudos.appAcademia.model.domain.Usuario;
import br.edu.estudos.appAcademia.model.service.UsuarioService;


@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "usuario/listar")
	public Iterable<Usuario> obterLista(){
		return usuarioService.obterLista();
	}
	
	@GetMapping(value = "usuario/{id}")
	public Usuario obterPorId(@PathVariable Integer id) {
		return usuarioService.obterPorId(id);
	}
	
	@PostMapping(value = "usuario/incluir")	
	public String incluir(@RequestBody(required = true)Usuario usuario) {
		
		usuarioService.incluir(usuario);
		
		return "A inclusão do " + usuario + " foi realizada com sucesso!!!";
	}
	
	@DeleteMapping(value = "usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		usuarioService.excluir(id);
		
		return "A exclusão do id " + id + " foi realizada com sucesso!!!";
	}
}