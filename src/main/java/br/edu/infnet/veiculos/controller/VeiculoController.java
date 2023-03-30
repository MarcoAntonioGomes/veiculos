package br.edu.infnet.veiculos.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.veiculos.model.domain.Veiculo;
import br.edu.infnet.veiculos.service.VeiculoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private static Logger log = LoggerFactory.getLogger(VeiculoController.class);

    @Autowired
    private VeiculoService veiculoService;


    @ApiOperation(value = "Serviço responsável por excluir o veiculo pelo identificador")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Veículo excluído com sucesso!"),
			@ApiResponse(code = 404, message = "Serviço indisponível!") })
    @GetMapping(value = "/veiculo/{id}/excluir")
    public String excluir(@PathVariable Integer id){
        veiculoService.excluir(id);
        return "redirect:/veiculo/lista";
    }
    @ApiOperation(value = "Serviço responsável por recuperar veículos pelos identificadores")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Veículos recuperado com sucesso!"),
			@ApiResponse(code = 404, message = "Serviço indisponível!") })
    @GetMapping("/all/by/ids")
    ResponseEntity<List<Veiculo>> getVeiculosByIds(@RequestParam List<Integer> ids){
        log.info("Buscando veículos por ids: " + ids);
        return ResponseEntity.ok(veiculoService.obterPorIds(ids));
    }


}
