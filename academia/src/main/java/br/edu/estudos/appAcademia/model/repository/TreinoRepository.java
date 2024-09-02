package br.edu.estudos.appAcademia.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.estudos.appAcademia.model.domain.Treino;

@Repository
public interface TreinoRepository extends CrudRepository<Treino, Integer> {

	Collection<Treino> findByUsuarioId(Integer id);

}
