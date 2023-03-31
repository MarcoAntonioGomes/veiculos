package br.edu.infnet.veiculos.service;




import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.veiculos.model.domain.Automovel;
import br.edu.infnet.veiculos.repository.AutomovelRepository;

@Service
public class AutomovelService {

    @Autowired
    private AutomovelRepository automovelRepository;

    public Automovel merge(Automovel automovel){
        return automovelRepository.save(automovel);
    }

    public void excluir(Integer id){
        automovelRepository.deleteById(id);
    }

    public Collection<Automovel> obterLista(){
        return (Collection<Automovel>) automovelRepository.findAll();
    }
}
