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
public class CadastraLocal extends BaseTest {
	LocalPage local = new LocalPage();
	
	private String nomeDoLocal = "HMFRC";
	
	@Test
	public void deveCadastrarLocal_1() throws InterruptedException {			
		local.acessarConvenio();
		local.acessarCadastro();		
		local.setNome(nomeDoLocal);
		local.clicarBotaoEnviar();
	}
	
	@Test
	public void deveVerificarLocal_2() throws InterruptedException {
		local.acessarConvenio();
		local.acessarListagem();
        assertEquals(nomeDoLocal, local.obterTexto("//*[@id=\"dtBasicExample\"]/tbody/tr["+ local.buscarElementoTabela(nomeDoLocal, 1) +"]/td[1]/a"));
	}
}
