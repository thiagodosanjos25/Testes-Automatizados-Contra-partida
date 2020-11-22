package br.pb.fabrica.testes;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.pb.fabrica.core.BaseTest;
import br.pb.fabrica.pages.EstagioPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditarEstagio extends BaseTest{
		EstagioPage estagio = new EstagioPage();
			
	@Test
	public void deveEditarEstagio_1() throws InterruptedException {
		estagio.clicarBotaoCadastro();
		estagio.acessarTelaListagem();
		estagio.clicarEstagio("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Medicina", 1) +"]/td[1]/a");
		estagio.clicarBotaoAlterar();
		
		estagio.setConcedente("Ortotrauma");
		estagio.setCurso("Enfermagem");
		estagio.setDisciplina("Saúde da Mulher");
		estagio.setTurno("Tarde");
		estagio.setQuantidadeDeAlunos("15");
		estagio.setCustoPorAluno("70.00");
		estagio.setPreceptor("Thiago");
		estagio.setLocal("Unimed");
		estagio.setTipoDeEstabelecimento("Unidade de saúde");
		estagio.setSetor("Bloco B");
		estagio.setData("15/11/2020");
		estagio.clicarBotaoEnviar();		
	}
	
	@Test
	public void deveVerificarEstagio_2() throws InterruptedException {
		estagio.acessarTelaEstagio();
		estagio.acessarTelaListagem();				
		
		assertEquals("Enfermagem", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Enfermagem", 1) +"]/td[1]/a"));
		assertEquals("Saúde da Mulher", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Saúde da Mulher", 2) +"]/td[2]"));
		assertEquals("Ortotrauma", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Ortotrauma", 3) +"]/td[3]"));
		assertEquals("Thiago", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Thiago", 4) +"]/td[4]"));
		assertEquals("Tarde", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Tarde", 5) +"]/td[5]"));
		assertEquals("Bloco B", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("Bloco B", 6) +"]/td[6]"));
		assertEquals("15", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("15", 7) +"]/td[7]"));
		assertEquals("1", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("1", 8) +"]/td[8]"));
		assertEquals("15 de Novembro de 2020", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("15 de Novembro de 2020", 9) +"]/td[9]"));
		assertEquals("15 de Novembro de 2020", estagio.obterTexto("//*[@id=\"content\"]/div[2]/table/tbody/tr["+ estagio.buscarElementoTabela("15 de Novembro de 2020", 10) +"]/td[10]"));
	}
}
