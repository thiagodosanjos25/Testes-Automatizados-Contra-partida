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
public class EditarLocal extends BaseTest {
	LocalPage local = new LocalPage();
	
	private String antigolocal = "HMFRC";
	private String novolocal = "João Paulo";
	
	@Test
	public void deveEditarLocal_1() throws InterruptedException {			
		local.acessarConvenio();
		local.acessarListagem();		
		local.clicarLocal("//*[@id=\"dtBasicExample\"]/tbody/tr["+ local.buscarElementoTabela(antigolocal, 1) +"]/td[1]/a");
		local.setNome(novolocal);
		local.clicarBotaoAlterar();
	}
	
	@Test
	public void deveVerificarLocal_2() throws InterruptedException {
		local.acessarConvenio();
		local.acessarListagem();
        assertEquals(novolocal, local.obterTexto("//*[@id=\"dtBasicExample\"]/tbody/tr["+ local.buscarElementoTabela(novolocal, 1) +"]/td[1]/a"));
	}
}
