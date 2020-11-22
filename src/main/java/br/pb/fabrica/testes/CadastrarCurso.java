package br.pb.fabrica.testes;

import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.pb.fabrica.core.BaseTest;
import br.pb.fabrica.pages.CursoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastrarCurso extends BaseTest {
	CursoPage curso = new CursoPage();	
	
	private String nomeDoCurso = "Fonoaudiologia";
	
	@Test
	public void deveCadastrarCurso_1() throws InterruptedException {
		curso.acessarTelaCurso();
		curso.acessarTelaCadastro();
		curso.setCurso(nomeDoCurso);
		curso.clickBtnEnviar();
	}
	
	@Test
	public void deveVerificarCurso_2() throws InterruptedException {
		curso.acessarTelaCurso();
		curso.acessarTelaListagem();
        assertEquals(nomeDoCurso, curso.obterTexto("//*[@id=\"content\"]/div[2]/div[2]/table/tbody/tr["+ curso.buscarElementoTabela(nomeDoCurso, 1) +"]/td[1]/a"));
	}
}
