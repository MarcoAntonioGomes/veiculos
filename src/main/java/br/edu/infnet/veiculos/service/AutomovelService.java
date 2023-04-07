package br.edu.infnet.veiculos.service;




import java.util.Collection;

import br.edu.infnet.veiculos.controller.AutomovelController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.veiculos.model.domain.Automovel;
import br.edu.infnet.veiculos.repository.AutomovelRepository;

@Service
public class AutomovelService {


    @Autowired
    private AutomovelRepository automovelRepository;
    private static final Logger LOG = LoggerFactory.getLogger(AutomovelService.class);

    public Automovel merge(Automovel automovel){
        Automovel automovelSaved =  automovelRepository.save(automovel);
        LOG.info("Automovel Criado Com Sucesso...");
        return automovelSaved;
    }

    public void excluir(Integer id){
        automovelRepository.deleteById(id);
        LOG.info("Automovel deletado Com Sucesso...");
    }

    public Collection<Automovel> obterLista(){
        Collection<Automovel> automoveis =  (Collection<Automovel>) automovelRepository.findAll();
        LOG.info("Automoveis criados com sucesso...");
        return automoveis;
    }
}
