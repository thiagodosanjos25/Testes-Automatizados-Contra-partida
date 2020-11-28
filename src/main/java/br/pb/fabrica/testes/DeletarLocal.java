package br.pb.fabrica.testes;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.pb.fabrica.core.BaseTest;
import br.pb.fabrica.pages.LocalPage;

/*
 *  Analista de Testes: Thiago dos Anjos Bezerra
 *  Data: 28/11/2020
 *  
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeletarLocal extends BaseTest {
	LocalPage local = new LocalPage();
	
	private String novolocal = "João Paulo";
	
	@Test
	public void deveDeletarLocal_1() throws InterruptedException {			
		local.acessarConvenio();
		local.acessarListagem();		
		local.clicarBotaoDeletar("//*[@id=\"dtBasicExample\"]/tbody/tr["+ local.buscarElementoTabela(novolocal, 1) +"]/td[2]/a");
		local.clicarBtnSubmit();
	}
	
	@Test
	public void deveVerificarLocal_2() throws InterruptedException {
		local.acessarConvenio();
		local.acessarListagem();
		assertEquals(-1, local.buscarElementoTabela(novolocal, 1));
	}
}
