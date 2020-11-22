
package br.pb.fabrica.testes;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.pb.fabrica.core.BaseTest;
import br.pb.fabrica.pages.CursoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeletarCurso extends BaseTest {
	CursoPage curso = new CursoPage();
	
	private String nomeDoCurso2 = "Engenharia Civil";
	
	@Test
	public void deveDeletarCurso_1() throws InterruptedException {
		curso.acessarTelaCurso();
		curso.acessarTelaListagem();
		curso.clicarBotaoDeletar("//*[@id=\"content\"]/div[2]/div[2]/table/tbody/tr["+ curso.buscarElementoTabela(nomeDoCurso2, 1) +"]/td[2]/a");
		curso.clicarBtnSubmit();				
	}

	@Test
	public void deveVerificarCurso_2() throws InterruptedException {
		curso.acessarTelaCurso();
		curso.acessarTelaListagem();
		assertEquals(-1, curso.buscarElementoTabela(nomeDoCurso2, 1));			
	}
}
