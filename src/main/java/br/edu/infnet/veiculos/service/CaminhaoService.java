package br.edu.infnet.veiculos.service;



import br.edu.infnet.veiculos.model.domain.Caminhao;
import br.edu.infnet.veiculos.relatorio.AppImpressao;
import br.edu.infnet.veiculos.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;


    public void incluir(Caminhao caminhao){

        caminhaoRepository.save(caminhao);

        new AppImpressao().relatorio(caminhao, "Inclusão do caminhão " + caminhao.getNome() + " realizada com sucesso!!!");
    }



    public  void excluir(Integer id){
        caminhaoRepository.deleteById(id);
    }

    public  Collection<Caminhao> obterLista(){
        return (Collection<Caminhao>) caminhaoRepository.findAll();
    }





}
