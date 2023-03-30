package br.edu.infnet.veiculos.controller;



import br.edu.infnet.veiculos.model.domain.Motocicleta;
import br.edu.infnet.veiculos.service.MotocicletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MotocicletaController {

    @Autowired
    private MotocicletaService motocicletaService;


    @PostMapping(value = "motocicleta/incluir")
    public String incluir(Motocicleta motocicleta){

        motocicletaService.incluir(motocicleta);

        return "redirect:/motocicleta/lista";
    }

    @GetMapping(value = "/motocicleta")
    public String telaCadastro(){
        return "motocicleta/cadastro";
    }


    @GetMapping(value = "/motocicleta/{id}/excluir")
    public String exclusao(@PathVariable Integer id){

        motocicletaService.excluir(id);
        return "redirect:/motocicleta/lista";
    }


}
