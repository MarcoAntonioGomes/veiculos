package br.edu.infnet.veiculos.service;




import br.edu.infnet.veiculos.model.domain.Automovel;
import br.edu.infnet.veiculos.relatorio.AppImpressao;
import br.edu.infnet.veiculos.repository.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AutomovelService {

    @Autowired
    private AutomovelRepository automovelRepository;

    public void incluir(Automovel automovel){

        automovelRepository.save(automovel);

        new AppImpressao().relatorio(automovel,"Inclusão do Automovel " + automovel.getNome() + " realizada com sucesso!!!");
    }

    public void excluir(Integer id){
        automovelRepository.deleteById(id);
    }

    public  Collection<Automovel> obterLista(){
        return (Collection<Automovel>) automovelRepository.findAll();
    }


}
