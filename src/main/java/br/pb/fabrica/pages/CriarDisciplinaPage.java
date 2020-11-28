package br.pb.fabrica.pages;
import org.openqa.selenium.By;
import br.pb.fabrica.core.BasePage;
import br.pb.fabrica.enums.CursoEnum;
import br.pb.fabrica.enums.TurnoEnum;

/*
 *  Analista de Testes: Thiago dos Anjos Bezerra
 *  Data: 28/11/2020
 *  
 */

public class CriarDisciplinaPage extends BasePage {
	
	public void setNomeDisciplina (String nomeDisciplina) {
		
		escreverPorXpath("//input[@id='id_nome']", nomeDisciplina);
	}
	
	public void setTurno (TurnoEnum turno) {
		
		selecionarCombo(By.id("id_turno"), turno.toString());
	}
	
	public void setCurso (CursoEnum curso) {
		
		selecionarCombo(By.id("id_curso"), curso.toString());
	}
	
	public void clickBtnEnviar () {
		clicarBotao("//button[@type='submit']");
	}

}
