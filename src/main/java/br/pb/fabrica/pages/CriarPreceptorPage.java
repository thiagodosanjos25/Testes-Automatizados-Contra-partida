package br.pb.fabrica.pages;

import org.openqa.selenium.By;

import br.pb.fabrica.core.BasePage;
import br.pb.fabrica.enums.CursoEnum;
import br.pb.fabrica.enums.DisciplinaEnum;

/*
 *  Analista de Testes: Thiago dos Anjos Bezerra
 *  Data: 28/11/2020
 *  
 */

public class CriarPreceptorPage extends BasePage {
	
	public void setNomePreceptor (String nomePreceptor) {
		
		escreverPorXpath("//input[@id='id_nome']", nomePreceptor);
	}
	
	public void setMatricula (String Matricula) {
		
		escreverPorXpath("//input[@id='id_matricula']", Matricula);
	}
	
	public void setCurso (CursoEnum curso) {
		
		selecionarCombo(By.id("id_curso"), curso.toString());
	}
	
	public void setDisciplina (DisciplinaEnum disciplina) {
		
		selecionarCombo(By.id("id_disciplina"), disciplina.toString());
	}
	
	public void clickBtnEnviar () {
		clicarBotao("//button[@type='submit']");
	}

}
