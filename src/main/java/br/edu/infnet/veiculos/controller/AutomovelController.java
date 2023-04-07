package br.edu.infnet.veiculos.controller;



import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.veiculos.model.domain.Automovel;
import br.edu.infnet.veiculos.service.AutomovelService;



@RestController
@RequestMapping(value = "/automovel")
public class AutomovelController {

   @Autowired
   private AutomovelService automovelService;
   private static final Logger LOG = LoggerFactory.getLogger(AutomovelController.class);

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> exclusao(@PathVariable Integer id){
        automovelService.excluir(id);
        LOG.info("Excluindo Automovel...");
        return new ResponseEntity<String>("Automovel excluído com sucesso!!", HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Automovel> incluir(@RequestBody Automovel automovel){
        Automovel automovelNovo = automovelService.merge(automovel);
        LOG.info("Criando Automovel...");
        return ResponseEntity.status(HttpStatus.CREATED).body(automovelNovo);
    }

    @GetMapping
    public ResponseEntity<Collection<Automovel>> listar(){
    	Collection<Automovel> lista = automovelService.obterLista();
        LOG.info("Buscando Automoveis...");
    	return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
    
    @PutMapping
    public ResponseEntity<Automovel> atualizar(@RequestBody Automovel automovel) {
    	Automovel automovelAtualizado = automovelService.merge(automovel);
        LOG.info("Atualizando Automoveis...");
    	return ResponseEntity.status(HttpStatus.OK).body(automovelAtualizado);
    }
}
