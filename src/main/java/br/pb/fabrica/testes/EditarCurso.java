package br.pb.fabrica.testes;

import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.pb.fabrica.core.BaseTest;
import br.pb.fabrica.pages.CursoPage;

/*
 *  Analista de Testes: Thiago dos Anjos Bezerra
 *  Data: 28/11/2020
 *  
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditarCurso extends BaseTest {
	CursoPage curso = new CursoPage();	
	
	private String nomeDoCurso = "Fonoaudiologia";
	private String nomeDoCurso2 = "Engenharia Civil";
	
	@Test
	public void deveEditarCurso_1() throws InterruptedException {
		curso.acessarTelaCurso();
		curso.acessarTelaListagem();
		curso.clicarCurso("//*[@id=\"content\"]/div[2]/div[2]/table/tbody/tr["+ curso.buscarElementoTabela(nomeDoCurso, 1) +"]/td[1]/a");
		curso.clicarAlterar();		
		curso.setCurso(nomeDoCurso2);
		curso.clickBtnEnviar();		
	}
	
	@Test
	public void deveVerificarCurso_2() throws InterruptedException {
		curso.acessarTelaCurso();
		curso.acessarTelaListagem();
        assertEquals(nomeDoCurso2, curso.obterTexto("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr["+ curso.buscarElementoTabela(nomeDoCurso2, 1) +"]/td[1]/a"));
	}

}
