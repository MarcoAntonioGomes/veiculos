package br.edu.infnet.veiculos.controller;



import br.edu.infnet.veiculos.model.domain.Caminhao;
import br.edu.infnet.veiculos.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @GetMapping(value = "/caminhao/{id}/excluir")
    public String exclusao(@PathVariable Integer id){

        caminhaoService.excluir(id);
        return "";
    }

    @PostMapping(value = "caminhao/incluir")
    public String incluir(Caminhao caminhao){

        caminhaoService.incluir(caminhao);

        return "";
    }

    @GetMapping(value = "/caminhao")
    public String telaCadastro(){
        return "caminhao/cadastro";
    }




}
