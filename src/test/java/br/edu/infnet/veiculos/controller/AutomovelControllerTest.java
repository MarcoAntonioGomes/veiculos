package br.edu.infnet.veiculos.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.infnet.veiculos.model.domain.Automovel;
import br.edu.infnet.veiculos.service.AutomovelService;


@SpringBootTest
@AutoConfigureMockMvc
public class AutomovelControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AutomovelService automovelService;

	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	void postIncluirAutomovelSuccessTest() throws Exception {
		Automovel automovel = getAutomovel();
		Mockito.when(automovelService.merge(Mockito.any())).thenReturn(automovel);
		mockMvc.perform(post("/automovel").contentType("application/json")
				.content(objectMapper.writeValueAsString(automovel))).andExpect(status().isCreated());
	}
	
	@Test
	void getListarAutomoveisSuccessTest() throws Exception {
		Automovel automovel = getAutomovel();
		Collection<Automovel> lista = new ArrayList<>();
		lista.add(automovel);
		Mockito.when(automovelService.obterLista()).thenReturn(lista);
		mockMvc.perform(get("/automovel").contentType("application/json")
				.content(objectMapper.writeValueAsString(lista))).andExpect(status().isOk());
	}
	
	@Test
	void putAtualizarAutomovelSuccessTest() throws Exception {
		Automovel automovel = getAutomovel();
		automovel.setId(1);
		automovel.setValor(20.000f);
		Mockito.when(automovelService.merge(Mockito.any())).thenReturn(automovel);
		mockMvc.perform(put("/automovel").contentType("application/json")
				.content(objectMapper.writeValueAsString(automovel))).andExpect(status().isOk());
	}

	@Test
	void deleteExclusaoAutomovelSuccessTest() throws Exception {
		Mockito.doNothing().when(automovelService).excluir(Mockito.anyInt());
		mockMvc.perform(delete("/automovel/1").contentType("application/json")
				.content(objectMapper.writeValueAsString("Automovel excluído com sucesso!!"))).andExpect(status().isNoContent());
	}

	
	private Automovel getAutomovel() {
		Automovel automovel = new Automovel();
		automovel.setNome("Fusca");
		automovel.setValor(15.000f);
		automovel.setMarca("VW");
		automovel.setQuantidadeDePortas(2);
		automovel.setTipo("passeio");
		automovel.setPossuiAirbag(false);
		return automovel;
	}
	
}
