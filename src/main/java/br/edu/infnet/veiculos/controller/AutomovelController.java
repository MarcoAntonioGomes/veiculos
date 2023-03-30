package br.edu.infnet.veiculos.controller;



import br.edu.infnet.veiculos.model.domain.Automovel;
import br.edu.infnet.veiculos.service.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AutomovelController {

   @Autowired
   private AutomovelService automovelService;

    @GetMapping(value = "/automovel/{id}/excluir")
    public String exclusao(@PathVariable Integer id){
        automovelService.excluir(id);
        return "redirect:/automovel/lista";
    }


    @PostMapping(value = "automovel/incluir")
    public String incluir(Automovel automovel){

        automovelService.incluir(automovel);

      return "";
    }

    @GetMapping(value = "/automovel")
    public String telaCadastro(){
        return "automovel/cadastro";
    }





}
