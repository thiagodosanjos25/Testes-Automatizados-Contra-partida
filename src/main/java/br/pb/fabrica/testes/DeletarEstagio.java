package br.pb.fabrica.testes;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.pb.fabrica.core.BaseTest;
import br.pb.fabrica.pages.EstagioPage;

/*
 *  Analista de Testes: Thiago dos Anjos Bezerra
 *  Data: 28/11/2020
 *  
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeletarEstagio extends BaseTest{
		EstagioPage estagio = new EstagioPage();
		
	@Test
	public void deveDeletarEstagio_1() throws InterruptedException {
		estagio.clicarBotaoCadastro();
		estagio.acessarTelaListagem();
		estagio.clicarBotaoDeletar("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("15 de Novembro de 2020", 9) +"]/td[12]/a");
		estagio.clicarBtnSubmit();			
	}
	
	@Test
	public void deveVerificarEstagio_2() throws InterruptedException {
		estagio.acessarTelaEstagio();
		estagio.acessarTelaListagem();
			
		assertEquals(-1, estagio.buscarElementoTabela("15 de Novembro de 2020", 9));	
  	}
}
