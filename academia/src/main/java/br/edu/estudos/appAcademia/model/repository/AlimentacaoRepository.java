package br.edu.estudos.appAcademia.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.estudos.appAcademia.model.domain.Alimentacao;

@Repository
public interface AlimentacaoRepository extends CrudRepository<Alimentacao, Integer> {

	Collection<Alimentacao> findByUsuarioId(Integer id);

}
