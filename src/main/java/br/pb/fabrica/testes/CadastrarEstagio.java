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
public class CadastrarEstagio extends BaseTest{
		EstagioPage estagio = new EstagioPage();
		
		@Test
	public void deveCadastrarEstagio_1() throws InterruptedException {
		estagio.clicarBotaoCadastro();
		estagio.acessarTelaCadastro();
		
		estagio.setConcedente("Ortotrauma");
		estagio.setCurso("Medicina");
		estagio.setDisciplina("Cirúrgico");
		estagio.setTurno("Integral");
		estagio.setQuantidadeDeAlunos("30");
		estagio.setCustoPorAluno("6000.00");
		estagio.setPreceptor("Wallace");
		estagio.setLocal("Hospital de Trauma");
		estagio.setTipoDeEstabelecimento("Unidade de saúde");
		estagio.setSetor("Bloco cirúrgico");
		estagio.setData("11/10/2020");
		estagio.clicarBotaoEnviar();		
	}

	@Test
	public void deveVerificarEstagio_2() throws InterruptedException {
		estagio.acessarTelaEstagio();
		estagio.acessarTelaListagem();	
		
		assertEquals("Medicina", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Medicina", 1) +"]/td[1]/a"));
		assertEquals("Cirúrgico", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Cirúrgico", 2) +"]/td[2]"));
		assertEquals("Ortotrauma", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Ortotrauma", 3) +"]/td[3]"));
		assertEquals("Wallace", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Wallace", 4) +"]/td[4]"));
		assertEquals("Integral", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Integral", 5) +"]/td[5]"));
		assertEquals("Bloco cirúrgico", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Bloco cirúrgico", 6) +"]/td[6]"));
		assertEquals("30", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("30", 7) +"]/td[7]"));
		assertEquals("1", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("1", 8) +"]/td[8]"));
		assertEquals("11 de Outubro de 2020", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("11 de Outubro de 2020", 9) +"]/td[9]"));
		assertEquals("11 de Outubro de 2020", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("11 de Outubro de 2020", 10) +"]/td[10]"));					
  	}	 	
}
