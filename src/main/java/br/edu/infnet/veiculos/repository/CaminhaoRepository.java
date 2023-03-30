package br.edu.infnet.veiculos.repository;




import br.edu.infnet.veiculos.model.domain.Caminhao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CaminhaoRepository extends CrudRepository<Caminhao, Integer> {


}
