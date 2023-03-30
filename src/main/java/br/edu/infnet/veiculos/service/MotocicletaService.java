package br.edu.infnet.veiculos.service;


import br.edu.infnet.veiculos.model.domain.Motocicleta;
import br.edu.infnet.veiculos.relatorio.AppImpressao;
import br.edu.infnet.veiculos.repository.MotocicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MotocicletaService {

    @Autowired
    private MotocicletaRepository motocicletaRepository;

    public void incluir (Motocicleta motocicleta){

        motocicletaRepository.save(motocicleta);
        new AppImpressao().relatorio(motocicleta, "Inclusão da motocicleta " + motocicleta.getNome() + " realizada com sucesso !!! ");
    }


    public void excluir(Integer id){
        motocicletaRepository.deleteById(id);
    }


    public Collection<Motocicleta> obterLista(){
        return (Collection<Motocicleta>) motocicletaRepository.findAll();
    }



}
