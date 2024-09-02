package br.edu.estudos.appAcademia.model.repository;

import java.util.Collection;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.estudos.appAcademia.model.domain.Aparelho;

@Repository
public interface AparelhoRepository extends CrudRepository<Aparelho, Integer> {
	Collection<Aparelho> findByMarcaContaining(String marca);

}
