package br.edu.estudos.appAcademia.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.estudos.appAcademia.model.domain.Usuario;
import br.edu.estudos.appAcademia.model.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void incluir(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public Iterable<Usuario> obterLista(){
		
		return usuarioRepository.findAll();
	}
	
	public Usuario obterPorId(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public long obterQtde() {
		return usuarioRepository.count();
	}

	public Usuario obterPorSobrenome(String sobrenome) {
		return usuarioRepository.findBySobrenome(sobrenome);
	}
}