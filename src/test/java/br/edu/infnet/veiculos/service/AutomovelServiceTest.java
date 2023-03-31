package br.edu.infnet.veiculos.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.edu.infnet.veiculos.model.domain.Automovel;
import br.edu.infnet.veiculos.repository.AutomovelRepository;


@ExtendWith(MockitoExtension.class)
public class AutomovelServiceTest {
	@Mock
	private AutomovelRepository automovelRepository;

	@InjectMocks
	private AutomovelService automovelService;
	
	@Test
	void mergeAutomovelSuccessTest() throws Exception {
		Automovel automovel = getAutomovel();
		automovel.setId(1);
		Mockito.when(automovelRepository.save(Mockito.any())).thenReturn(automovel);
		Automovel automovelCreate = automovelService.merge(automovel);
		assertThat(automovelCreate.getId()).isEqualTo(1);
	}
	
	@Test
	void excluirAutomovelSuccessTest() throws Exception {
		Mockito.doNothing().when(automovelRepository).deleteById(Mockito.anyInt());
		automovelService.excluir(1);
		 verify(automovelRepository, times(1)).deleteById(1);
	}
	
	@Test
	void obterListaAutomovelSuccessTest() throws Exception {
		Automovel automovel = getAutomovel();
		Collection<Automovel> lista = new ArrayList<>();
		lista.add(automovel);
		Mockito.when(automovelRepository.findAll()).thenReturn(lista);
		Collection<Automovel> listaAtual = automovelService.obterLista();
		assertThat(listaAtual.size()).isEqualTo(1);
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
