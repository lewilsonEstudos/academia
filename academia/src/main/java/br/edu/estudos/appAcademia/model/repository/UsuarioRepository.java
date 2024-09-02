package br.edu.estudos.appAcademia.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.estudos.appAcademia.model.domain.Usuario;
;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	Usuario findBySobrenome(String sobrenome);

	Collection<Usuario> findAll(Sort orderBy);
}