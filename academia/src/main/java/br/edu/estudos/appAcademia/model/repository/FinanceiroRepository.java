package br.edu.estudos.appAcademia.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.estudos.appAcademia.model.domain.Financeiro;

@Repository
public interface FinanceiroRepository extends CrudRepository<Financeiro, Integer> {

	Collection<Financeiro> findByUsuarioId(Integer id);
}
