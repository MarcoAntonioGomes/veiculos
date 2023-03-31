package br.edu.infnet.veiculos.repository;



import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.veiculos.model.domain.Automovel;


public interface AutomovelRepository extends CrudRepository<Automovel, Integer> {



}
